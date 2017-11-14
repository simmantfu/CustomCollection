package com.custom;

public class CustomHashMap<K extends Integer, T extends Object> {

	private static final int capacity_init = 10;
	static final float DEFAULT_LOAD_FACTOR = 0.75f;

	Entity[] bucket = null;

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
			Entity head = new Entity(null, null, null);
			Entity next = new Entity(key, value, null);
			head.next = next;
			bucket[hashcode] = head;
		} else {

			Entity temp = bucket[hashcode];
			while (temp.next != null) {
				temp = temp.next;
			}
			Entity neEntity = new Entity(key, value, null);
			temp.next = neEntity;
		}

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
			while (temp.next != null) {
				temp = temp.next;
				if (temp.key.equals(key)) {
					return (T) temp.value;
				}
			}
			return null;
		}

	}

	
	/*
	 * Below is the steps to description about how update method will work
	 * 
	 * i)  1st it will get current data from get method and assign to new data object.
	 * ii) Then it will call hash method for key passed with method, and will check with same hashcode in bucket and assign it to update object.
	 * iii) Then passed value, will assign to value of update.next, and then update Object will assign to bucket to same hashcode.
	 * iv) After that method will return oldvalue.
	 */
	
	public T update(K key, T value) {
		T oldvalue = get(key);
		int hashcode = hash(key);
		Entity update = bucket[hashcode];
        update.next.value = value;
		bucket[hashcode] = update;
		return oldvalue;
	}

	public void delete(K key){
		int hashcode = hash(key);
		Entity deleteNode = bucket[hashcode];
		deleteNode = null;
		bucket[hashcode] = deleteNode;
	}
	
	static class Entity<K, T> {
		K key;
		T value;
		Entity next;

		public Entity(K key, T value, Entity next) {

			this.key = key;
			this.value = value;
			this.next = next;

		}

	}

 //Example How to use this map
	public static void main(String... str) {

		CustomHashMap<Integer, Object> customHashMap = new CustomHashMap<>();
		customHashMap.add(1, 1);
		customHashMap.add(1, "simmant");

		System.out.println(customHashMap.get(1));
		System.out.println(customHashMap.get(1));
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
