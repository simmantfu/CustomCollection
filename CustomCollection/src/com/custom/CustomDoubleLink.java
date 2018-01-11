package com.custom;

import java.util.Iterator;
import java.util.Objects;

public class CustomDoubleLink<V> implements Iterable<V> {

	Node start;
    Node end; 
	
	public void add(V data) {

		Node node = new Node<V>(null, null, data);
		Node last = start;
		if (start == null) {
			start = node;
		} else {

			while (last.next != null) {
				last = last.next;
			}
			last.next = node;
			node.prev = last;
			end = node;
		}

	}

	public void print() {

		Node ptr = start;
		while (ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
	}

	public void printREV() {

		Node ptr = end;
		while (ptr != null) {
			System.out.println(ptr.data);
			ptr = ptr.prev;
		}
	}
	
	public void delete(int i){
		
		Node ptr = start;
		
		for(int j=1;j<i;j++){
			ptr = ptr.next;
		}
		
		
		
		ptr.next= ptr.next.next;
		
	}
	
	class Node<V> {
		V data;

		Node prev;
		Node next;

		Node(Node prev, Node next, V data) {
			this.data = data;
			this.next = next;
			this.data = data;

		}

		public V getData() {
			return data;
		}

		public void setData(V data) {
			this.data = data;
		}

		public Node getPrev() {
			return prev;
		}

		public void setPrev(Node prev) {
			this.prev = prev;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

	}

	@Override
	public Iterator<V> iterator() {
		// TODO Auto-generated method stub
		return new DoubleItr();
	}

	class DoubleItr implements Iterator<V> {

		Node ptr = start;

		@Override
		public boolean hasNext() {
			
			Node itr = ptr;
			boolean flag = false;
			if (Objects.nonNull(itr)) {
				flag = true;
			}

			return flag;
		}

		@Override
		public V next() {
			
			if (hasNext()) {
				V data = (V) ptr.data;
				ptr = ptr.next;
				return data;
			} else
				return null;
		}

	}

	public static void main(String... strings) {

		CustomDoubleLink<Integer> customDoubleLink = new CustomDoubleLink<>();
		customDoubleLink.add(1);
		customDoubleLink.add(2);
		customDoubleLink.add(3);
		customDoubleLink.add(4);
		// customDoubleLink.print();

//		for (int i : customDoubleLink) {
//			System.out.println(i);
//		}
		
		customDoubleLink.print();
		customDoubleLink.delete(2);
		
		System.out.println("After");
		customDoubleLink.print();
		

	}

}
