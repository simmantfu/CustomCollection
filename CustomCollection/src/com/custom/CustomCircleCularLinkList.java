package com.custom;

import java.util.Objects;

public class CustomCircleCularLinkList<V> {

	Node head;
	Node end;
	public void add(V data) {
		Node ptr = new Node<V>(data, null);
		if(Objects.isNull(head)) {
			head = ptr;
			end = head;
			head.nextRef = end;
			end.nextRef = head;
		}else {
			ptr.nextRef = head;
		    head = ptr;
		    end.nextRef = head;
		}
		
	}
	
	public void print(){
		
		Node ptr = head;
		
		while(ptr.nextRef !=head) {
			System.out.println(ptr.data);
			ptr = ptr.nextRef;
		}
		System.out.println(ptr.data);
	}
	
	public void add(V data,int pos) {
		
		
		Node newD = new Node<V>(data, null);
		Node ptr = head;
		
		for(int i=1;i<=pos;i++) {
			ptr = ptr.nextRef;
		}
	    newD.nextRef = ptr.nextRef;
		ptr.nextRef = newD;
	}
	
	public void addToStart(V data) {
		Node ptr =  new Node<V>(data, null);
		ptr.nextRef = head;
		head = ptr;
		end.nextRef = head;
	}
	
	public void addToEnd(V data){
		Node ptr = new Node<V>(data, null);
		ptr.nextRef = end.nextRef;
		end.nextRef = ptr;
	}
	
	class Node<V>{
		V data;
		Node nextRef;
		
		Node(V data,Node nextRef){
			this.data = data;
			this.nextRef = nextRef;
		}
		
	}
	
	
	
	
	public static void main(String...strings) {
		CustomCircleCularLinkList<Integer> circleCularLinkList = new CustomCircleCularLinkList<>();
		circleCularLinkList.add(1);
		circleCularLinkList.add(2);
		circleCularLinkList.add(3);
		
		circleCularLinkList.add(10, 0);
		
		circleCularLinkList.addToStart(11);
		
		circleCularLinkList.addToEnd(12);
		
		circleCularLinkList.print();
	}
	
}
