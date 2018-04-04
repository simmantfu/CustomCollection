package com.custom.tree;



public class EntryNode<K, V> {

	EntryNode<K, V> left = null;
	EntryNode<K, V> right = null;
	K key = null;
	V value = null;
	int indexHashValue = 0;

	

	protected EntryNode(K key, V value) {
		this.key = key;
		this.value = value;
		this.indexHashValue = hash(this.key.hashCode());

	}

	protected void put(K key, V value) {
		int tempHashValue = hash(key.hashCode());

		if (this.indexHashValue < tempHashValue) {

			if (this.left == null) {
				this.left = new EntryNode<K, V>(key, value);
			} else {
				this.left.put(key, value);
			}

		} else {

			if (this.right == null) {
				this.right = new EntryNode<K, V>(key, value);
			} else {
				this.right.put(key, value);
			}

		}

	}

	protected void print() {
		System.out.println(this.key + "" + this.value);
		if (this.left != null) {
			this.left.print();
		}
		if (this.right != null) {
			this.right.print();
		}
	}

	int hash(int hashCode) {

		String s = new String(hashCode + "");
		int result = 0;

		for (char c : s.toCharArray()) {

			result = result + c;

		}

		return result;
	}

}

