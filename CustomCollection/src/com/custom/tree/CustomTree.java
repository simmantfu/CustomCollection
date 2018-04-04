package com.custom.tree;

import java.util.Iterator;

public class CustomTree<K, V> implements Iterable<EntryNode> {

	EntryNode<K, V> root = null;

	public void put(K key, V value) {

		if (this.root == null) {
			this.root = new EntryNode<>(key, value);
		} else {

			this.root.put(key, value);
		}
	}

	public void print() {

		root.print();
	}

	@Override
	public Iterator<EntryNode> iterator() {
		// TODO Auto-generated method stub
		return new TreeMapItr();
	}

	class TreeMapItr implements Iterator<EntryNode> {

		EntryNode itrTemp = root;
		EntryNode result = itrTemp;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return result != null;
		}

		@Override
		public EntryNode next() {
			// TODO Auto-generated method stub

			if (result.left != null) {
				result = result.left;

			} else {
				result = itrTemp.right;
			}

			return result;

		}

	}

	public static void main(String... strings) {
		CustomTree<Integer, Integer> customTree = new CustomTree<>();

		customTree.put(1, 2);
		customTree.put(2, 3);
		customTree.put(3, 4);

		// customTree.print();

		for (EntryNode e : customTree) {
			System.out.println(e.key + " " + e.value);
		}

	}

}
