package com.custom.map;

import java.util.Iterator;
import java.util.Objects;
import com.custom.utils.*;

public class CustomHashMap<K, T> implements Iterable<Entity> {

	private static final int capacity_init = 10;
	static final float DEFAULT_LOAD_FACTOR = 0.75f;
	private int indexCount = 0;

	Entity[] bucket = null;

	Entity[] bucketItr = null;

	public CustomHashMap() {
		init(capacity_init);
	}

	public CustomHashMap(int capacity) {
		init(capacity);
	}

	private void init(int intcapacity) {

		bucket = new Entity[intcapacity];
	}

	private int hash(Object key) {

		return key.hashCode() >> 1;
	}

	/*
	 * Below is the steps to description about how add method will work
	 * 
	 * i) 1st it will get hashcode from hash method and then will check current
	 * hashcode in index of bucket. ii) If index is null, then null head entry
	 * will create and nextEntry for head will create with key & value, this
	 * value will assign to head next and head will assign to current null
	 * index. iii) If index is not empty then, we assign current index value to
	 * temp variable and will temp next until we not received next as null. iv)
	 * Once temp null is been found, then new key value pair will assign to next
	 * and added to temp.next object.
	 */

	public void add(K key, T value) {

		int hashcode = hash(key);

		if (indexCount == bucket.length) {
			Entity[] obj = bucket;
			int k = (int) (obj.length * 2);
			bucket = new Entity[k];
			System.arraycopy(obj, 0, bucket, 0, indexCount - 1);
		}

		if (bucket[hashcode] == null) {
			indexCount++;
			Entity head = new Entity(key, value, null);
			bucket[hashcode] = head;
		} else {
			Entity temp = bucket[hashcode];
			while (temp.next != null) {
				temp = temp.next;
			}
			Entity neEntity = new Entity(key, value, null);
			neEntity.next = temp;
			bucket[hashcode] = neEntity;

		}

		bucketItr = new Entity[indexCount];
		System.arraycopy(bucket, 0, bucketItr, 0, indexCount);

	}

	/*
	 * Below is the steps to description about how get method will work
	 * 
	 * i) 1st it will get hashcode from hash method and then will check current
	 * hashcode in index of bucket. ii) If index is null, then method will
	 * simply return null. iii) If index is not empty then, we assign current
	 * index value to temp variable and will loop temp next until we not
	 * received next as null. iv) Inside of loop we will compare key passed with
	 * method and key of temp variable, if both key get match then we will
	 * return temp.data.
	 */

	public T get(K key) {
		int hashcode = hash(key);
		if (bucket[hashcode] == null) {
			return null;
		} else {
			Entity temp = bucket[hashcode];
			while (temp != null) {

				if (temp.key.equals(key)) {
					return (T) temp.value;
				}
				temp = temp.next;
			}
			return null;
		}

	}

	public void delete(K key) {
		int hashcode = hash(key);
		Entity deleteNode = bucket[hashcode];
		deleteNode = null;
		bucket[hashcode] = deleteNode;
	}

	@Override
	public Iterator<Entity> iterator() {

		return new MapItr();
	}

	class MapItr implements Iterator<Entity> {

		int count = 0;
		Entity node = bucketItr[0];

		@Override
		public boolean hasNext() {
			return count < bucketItr.length;
		}

		@Override
		public Entity next() {

			Entity result = null;

			if (hasNext()) {
				result = node;
				if (Objects.nonNull(node) && node.next != null) {
					node = node.next;
				} else {
					count++;
					if (count < bucketItr.length)
						node = bucketItr[count];
				}

				return result;
			} else {
				return null;
			}
		}

	}

	// Example How to use this map
	public static void main(String... str) {

		CustomHashMap<Integer, Object> customHashMap = new CustomHashMap<>();
		customHashMap.add(1, "Test1");
		customHashMap.add(2, "Test2");
		customHashMap.add(3, "Test3");
		customHashMap.add(4, "Test4");
		customHashMap.add(5, "Test5");
		customHashMap.add(6, "Test6");
		customHashMap.add(7, "Test7");

		// Order of Output in map is depends on Hash value of key.
		for (Entity e : customHashMap) {

			System.out.println(e.key + " " + e.value);
		}

	}

}
