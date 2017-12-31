package com.custom;

import java.util.Iterator;
import java.util.Objects;

public class CustomLinkList<V extends Object> implements Iterable<V> {

	Node start;
	Node end;
	Node ptr1;
	V data;
	int size = 0;

	public CustomLinkList() {
		start = null;
		end = null;
		data = null;
	}

	public void addAtFirst(V data) {
		Node<Object> node = new Node<>(data, null);

		if (start == null) {
			start = node;
			end = start;
		} else {
			node.setNextLink(start);
			start = node;
		}
		size++;
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

	public Node getIndex(int pos) {
		Node ptr = start;
		for (int i = 0; i <= pos; i++) {

			if (pos == i) {
				return ptr;
			}
			ptr = ptr.getNextLink();
		}
		return null;
	}

	public void pop() {
		Node temp = start.nextLink;
		start = null;
		start = temp;
	}

	public void addpos(V data, int pos) {
		Node add = new Node(data, null);
		int i_x = pos - 1;

		// add.nextLink = start;

		Node previous = start;

		for (int i = 0; i <= pos - 1; i++) {
			previous = previous.nextLink;
		}

		add.nextLink = previous.nextLink;
		previous.nextLink = add;

		size++;
	}

	public void printEnd() {
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

	@Override
	public Iterator<V> iterator() {
		// TODO Auto-generated method stub
		return new LinkItr();
	}

	class LinkItr implements Iterator<V> {

		Node itrStart = start;
		V data;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub

			boolean flag = false;
			if (!Objects.isNull(itrStart)) {
				data = (V) itrStart.data;
				flag = true;
			}

			return flag;
		}

		@Override
		public V next() {
			// TODO Auto-generated method stub

			if (hasNext()) {
				itrStart = itrStart.nextLink;
				return data;
			} else {
				return null;
			}

		}

	}

	public static void main(String... strings) {
		CustomLinkList<Integer> customLinkList = new CustomLinkList<>();
		customLinkList.addAtFirst(1);
		customLinkList.addAtFirst(2);
		customLinkList.addAtFirst(3);
		customLinkList.addAtFirst(4);
		customLinkList.addAtFirst(5);
		customLinkList.addAtFirst(6);
		customLinkList.addAtFirst(7);
		customLinkList.addAtFirst(8);

		// customLinkList.printEnd();

		// customLinkList.pop();
		// customLinkList.display();

		// customLinkList.addpos(12, 0);

		for (int k : customLinkList) {

			System.out.println(k);

		}
		// customLinkList.display();
		// System.out.println(customLinkList.get(0));

	}

}
