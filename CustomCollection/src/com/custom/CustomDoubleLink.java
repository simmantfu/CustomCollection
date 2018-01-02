package com.custom;

import org.w3c.dom.css.CSSUnknownRule;

public class CustomDoubleLink<V> {

	Node start;
	

	public void add(V data){
		
		Node node = new Node<V>(null, null, data);
		Node last = start;
		if(start == null){
			start = node;
			}else{
				
				while(last.next!=null){
				  last = last.next;
				}
		      last.next = node;
		      node.prev = last;
		}
		
	}

	public void printREV(){
		
		Node ptr = start;
		while(ptr!=null)
		{
			System.out.println(ptr.data);
			ptr = ptr.next;
		}
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

	
	public static void main(String...strings){
		CustomDoubleLink<Integer> customDoubleLink = new CustomDoubleLink<>(); 
		customDoubleLink.add(1);
		customDoubleLink.add(2);
		customDoubleLink.add(3);
		
		customDoubleLink.printREV();
//		
	
		int a = 'c';
		
	}
	
}
