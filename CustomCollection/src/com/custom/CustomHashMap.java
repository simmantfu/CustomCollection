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

// Example How to use this map
//	public static void main(String... str) {
//
//		CustomHashMap<Integer, Object> customHashMap = new CustomHashMap<>();
//		customHashMap.add(2, 1);
//		customHashMap.add(1, "simmant");
//
//		System.out.println(customHashMap.get(1));
//		System.out.println(customHashMap.get(2));
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
//	}

}
