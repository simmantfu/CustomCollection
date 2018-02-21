package com.custom;

import java.util.Iterator;

public class CustomQueueList<V> implements Iterable<V> {

	private Node<V> start;

	private Node<V> end;

	private static int size = 0;

	public void enqueue(V data) {

		Node<V> node = new Node<>(data, null);

		if (start == null) {
			start = node;
			end = start;

		} else {

			end.setNext(node);
			end = node;

		}

		size++;
	}

	public V dequeue() {
		V oldData = start.getData();
		start = start.next;
		size--;
		return oldData;
	}

	public void print() {
		Node<V> temp = start;

		while (temp != null) {

			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	public V get(int index) {

		Node<V> temp = start;
		Node<V> k = null;
		for (int i = 0; i < index; i++) {

			if (temp != null) {
				k = temp;
				temp = temp.getNext();
			}
		}

		return k.getData();
	}

	class Node<V> {
		V data = null;
		Node<V> next = null;

		public Node(V data, Node<V> next) {
			this.data = data;
			this.next = next;
		}

		public V getData() {
			return data;
		}

		public void setData(V data) {
			this.data = data;
		}

		public Node<V> getNext() {
			return next;
		}

		public void setNext(Node<V> next) {
			this.next = next;
		}

	}

	public int size() {
		return size;
	}

	public void clear() {
		start = null;

		size = 0;
	}

	@Override
	public Iterator<V> iterator() {
		// TODO Auto-generated method stub

		Node<V> itrObj = start;

		return new CustomQueueListItr(itrObj);
	}

	private class CustomQueueListItr implements Iterator<V> {

		Node<V> ItrObj = null;
		Node<V> ItrObjRT = null;

		public CustomQueueListItr(Node<V> ItrObj) {
			this.ItrObj = ItrObj;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			boolean flag = false;

			if (ItrObj != null) {
				ItrObjRT = ItrObj;
				ItrObj = ItrObj.getNext();
				flag = true;
			}

			return flag;
		}

		@Override
		public V next() {
			// TODO Auto-generated method stub
			return ItrObjRT.getData();
		}

	}

	public static void main(String... strings) {

		CustomQueueList<Integer> customQueueList = new CustomQueueList<>();
		customQueueList.enqueue(1);
		customQueueList.enqueue(2);
		customQueueList.enqueue(3);

		for (int a : customQueueList) {
			customQueueList.dequeue();
			// System.out.println(a);

		}

		for (Integer integer : customQueueList) {
			System.out.println(integer);
		}

		// System.out.println("Before Dequeue--------------------");
		// // customQueueList.print();
		//
		// System.out.println(customQueueList.get(4));
		//
		// // customQueueList.dequeue();
		// // System.out.println("After Dequeue--------------------");
		// // customQueueList.print();
		// //
		// // customQueueList.dequeue();
		// // System.out.println("After Dequeue 2--------------------");
		// // customQueueList.print();

	}

}
