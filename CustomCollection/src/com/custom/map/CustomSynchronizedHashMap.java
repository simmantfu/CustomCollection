package com.custom.map;

import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.locks.*;

import com.custom.utils.Entity;

public class CustomSynchronizedHashMap<K, T> implements Iterable<Entity<K, T>> {

	private Lock lock = new ReentrantLock();
	private static final int capacity_init = 10;
	static final float DEFAULT_LOAD_FACTOR = 0.75f;
	private int indexCount = 0;

	Entity<K, T>[] bucket = null;

	Entity<K, T>[] bucketItr = null;

	public CustomSynchronizedHashMap() {
		init(capacity_init);
	}

	public CustomSynchronizedHashMap(int capacity) {

		init(capacity);
	}

	private void init(int intcapacity) {

		bucket = new Entity[intcapacity];
	}

	private int hash(Object key) {

		return key.hashCode() >> 1;
	}

	public void add(K key, T value) {
		lock.lock();
		try {

			int hashcode = hash(key);
			if (indexCount == bucket.length) {
				Entity<K, T>[] obj = bucket;
				int k = (int) (obj.length * 2);
				bucket = new Entity[k];
				System.arraycopy(obj, 0, bucket, 0, indexCount - 1);
			}
			if (bucket[hashcode] == null) {
				indexCount++;
				Entity<K, T> head = new Entity<K, T>(key, value, null);
				bucket[hashcode] = head;
			} else {
				Entity<K, T> temp = bucket[hashcode];
				while (temp.next != null) {
					temp = temp.next;
				}
				Entity<K, T> neEntity = new Entity<K, T>(key, value, null);
				neEntity.next = temp;
				bucket[hashcode] = neEntity;

			}

		} finally {
			lock.unlock();
		}

	}

	public T get(K key) {
		lock.lock();
		try {
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
		} finally {
			lock.unlock();
		}
	}

	public void delete(K key) {
		int hashcode = hash(key);
		Entity<K, T> deleteNode = bucketItr[hashcode];
		deleteNode = null;
		bucketItr[hashcode] = deleteNode;
	}

	@Override
	public Iterator<Entity<K, T>> iterator() {
		bucketItr = new Entity[indexCount - 1];
		System.arraycopy(bucket, 0, bucketItr, 0, indexCount - 1);
		return new MapItr();
	}

	class MapItr implements Iterator<Entity<K, T>> {

		int count = 0;
		Entity<K, T> node = bucketItr[0];

		@Override
		public boolean hasNext() {
			return count < bucketItr.length;
		}

		@Override
		public Entity<K, T> next() {

			Entity<K, T> result = null;

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
}
