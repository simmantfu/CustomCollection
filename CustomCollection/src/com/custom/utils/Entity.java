package com.custom.utils;



public class Entity<K, T> {
	public K key;
	public T value;
	public Entity next;

	public Entity(K key, T value, Entity next) {

		this.key = key;
		this.value = value;
		this.next = next;

	}

}