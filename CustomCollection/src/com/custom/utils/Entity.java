package com.custom.utils;



public class Entity<K, V> {
	public K key;
	public V value;
	public Entity<K,V> next;

	public Entity(K key, V value, Entity<K,V> next) {

		this.key = key;
		this.value = value;
		this.next = next;

	}

}