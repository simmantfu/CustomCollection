package com.custom;


public class CustomLinkList<V extends Object> {

	Node start;
	Node end;
	V data;
	int size = 0;

	public CustomLinkList() {
		start = null;
		end = null;
		data = null;
	}

	public void addAtFirst(V data) {
		Node<Object> node = new Node<>(data, null);
		size++;
		if (start == null) {
			start = node;
			end = start;
		} else {
			node.setNextLink(start);
			start = node;
		}

	}

	public void addAtEnd(V data) {
		Node<Object> node = new Node<>(data, null);
		size++;
		if (start == null) {
			start = node;
			end = start;
		} else {
			end.setNextLink(node);
			end = node;
		}

	}

	public void display() {
		if (size != 0) {
			Node ptr = start;
			System.out.println(ptr.getData());
			ptr = start.getNextLink();
			while (ptr.getNextLink() != null) {
				System.out.println(ptr.getData());
				ptr = ptr.getNextLink();
			}
			System.out.println(ptr.getData());
		}

	}

	public V get(int pos) {
		Node ptr = start;
		for (int i = 0; i <= pos; i++) {

			if (pos == i) {
				return (V) ptr.getData();
			}
			ptr = ptr.getNextLink();
		}
		return null;
	}

	public void printEnd(){
		System.out.println(end.getData());
	}
	
	static class Node<V> {
		V data;
		Node nextLink;

		Node(V data, Node nextLink) {
			this.data = data;
			this.nextLink = nextLink;
		}

		public V getData() {
			return data;
		}

		public void setData(V data) {
			this.data = data;
		}

		public Node getNextLink() {
			return nextLink;
		}

		public void setNextLink(Node nextLink) {
			this.nextLink = nextLink;
		}

	}

// This how linklist will work	
//	public static void main(String... strings) {
//		CustomLinkList<Integer> customLinkList = new CustomLinkList<>();
//		customLinkList.addAtFirst(1);
//		customLinkList.addAtEnd(2);
//		customLinkList.addAtEnd(5);
//		customLinkList.addAtFirst(3);
//		customLinkList.addAtFirst(4);
//
//		customLinkList.printEnd();
//		
//		// customLinkList.display();
//		//System.out.println(customLinkList.get(0));
//
//	}
}
