package com.custom;

import java.util.Iterator;
import java.util.Objects;

public class CustomHashMap<K, T> implements Iterable<Entity>{

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

		return key.hashCode() ^ 5;
	}

	/*
	 * Below is the steps to description about how add method will work
	 * 
	 * i)  1st it will get hashcode from hash method and then will check current hashcode in index of bucket.
	 * ii) If index is null, then null head entry will create and nextEntry for head will create with key & value, 
	 *     this value will assign to head next and head will assign to current null index.
	 * iii) If index is not empty then, we assign current index value to temp variable and will temp next until we not received next as null.
	 * iv) Once temp null is been found, then new key value pair will assign to next and added to temp.next object.  
	 */
	
	public void add(K key, T value) {

		int hashcode = hash(key);
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

		bucketItr = new Entity[bucket.length];
		System.arraycopy(bucket, 0, bucketItr, 0, bucket.length);
		
	}

	/*
	 * Below is the steps to description about how get method will work
	 * 
	 * i)  1st it will get hashcode from hash method and then will check current hashcode in index of bucket.
	 * ii) If index is null, then method will simply return null. 
	 * iii) If index is not empty then, we assign current index value to temp variable and will loop temp next until we not received next as null.
	 * iv) Inside of loop we will compare key passed with method and key of temp variable, if both key get match then we will return temp.data.
	 */

	
	public T get(K key) {
		int hashcode = hash(key);
		if (bucket[hashcode] == null) {
			return null;
		} else {
			Entity temp = bucket[hashcode];
			while (temp!= null) {
				
				if (temp.key.equals(key)) {
					return (T) temp.value;
				}
				temp = temp.next;
			}
			return null;
		}

	}

	
	public void delete(K key){
		int hashcode = hash(key);
		Entity deleteNode = bucket[hashcode];
		deleteNode = null;
		bucket[hashcode] = deleteNode;
	}
	
	@Override
	public Iterator<Entity> iterator() {
		// TODO Auto-generated method stub
		bucketItr =  new Entity[indexCount];
		int entryCount = 0;
		for(Entity e:bucket) {
			
			if(Objects.nonNull(e)) {
				bucketItr[entryCount] = e;
				entryCount++;
			}
			
		}
		
		return new MapItr();
	}
	
	
	class MapItr implements Iterator<Entity>{

		int count =0;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return this.count<bucketItr.length;
		}

		@Override
		public Entity next() {
			// TODO Auto-generated method stub
			
			if(hasNext()){
				Entity node  = bucketItr[count];
				count++;
				return node;
			}else {
			return null;
			}
		}
		
	}
	
	
	

 //Example How to use this map
	public static void main(String... str) {

		CustomHashMap<Integer, Object> customHashMap = new CustomHashMap<>();
		customHashMap.add(1, 1);
		customHashMap.add(2, "simmant");
		customHashMap.add(3, "simmant1"); 
		
//		System.out.println(customHashMap.get(1));
//		System.out.println(customHashMap.get(2));
//		System.out.println(customHashMap.get(3));
		
		// Order of Output in map is depends on Hash value of key.
		for(Entity e:customHashMap) {
			
			System.out.println(e.key+" "+e.value);
		}
//		
//		customHashMap.update(2, 2);
//		
//		System.out.println(customHashMap.get(1));
//		System.out.println(customHashMap.get(2));
//		
//		customHashMap.delete(2);
//		
//		System.out.println(customHashMap.get(2));// null will be return 
//		
//		System.out.println(customHashMap.get(5));// null will be return 
	}



}

class Entity<K, T> {
	K key;
	T value;
	Entity next;

	public Entity(K key, T value, Entity next) {

		this.key = key;
		this.value = value;
		this.next = next;

	}

}
