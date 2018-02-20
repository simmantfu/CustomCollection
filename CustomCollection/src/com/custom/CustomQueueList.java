package com.custom;

public class CustomQueueList<V> {

	Node start;

	Node end;
	
	public void enqueue(V data) {

		Node<V> node = new Node<>(data, null);

		if (start == null) {
			start = node;
			end = start;
			
		} else {

			end.setNext(node);
			end = node;
			
			System.out.println();
//			Node t = start;
//			Node k= null;
//			while (t != null) {
//				k = t;
//				t = t.next;
//			}
//			k.setNext(node);

		}

	}

	public void print() {
		Node temp = start;

		while (temp != null) {

			System.out.println(temp.data);
			temp = temp.next;
		}
	}

	class Node<V> {
		V data=null;
		Node next=null;

		public Node(V data, Node next) {
			this.data = data;
			this.next = next;
		}

		public V getData() {
			return data;
		}

		public void setData(V data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

	public static void main(String... strings) {

		CustomQueueList<Integer> customQueueList = new CustomQueueList<>();
		customQueueList.enqueue(1);
		customQueueList.enqueue(2);
		customQueueList.enqueue(3);

		customQueueList.print();

	}

}
