package com.custom;

public class CustomUnrolList<V> {

	Node start;
	int count = 0;
	Object[] dataBucket = new Object[10];

	public void add(V data) {
		if (count < 10) {
			dataBucket[count] = data;
			count++;
		} 
		
		if(count == 10){
			Node ptr = new Node(dataBucket, null);
			if (start == null) {
				start = ptr;
			} else {
				ptr.next = start;
				start = ptr;
			}
			count = 0;
			dataBucket = new Object[10];
		}
	}

	public void print() {

		Node ptr = start;

		while (ptr != null) {
			for (Object obs : ptr.data) {
				System.out.println(obs);
			}
			ptr = ptr.next;
		}

	}

	static class Node<V> {
		V[] data;
		Node next;

		Node(V[] data, Node next) {
			this.data = data;
			this.next = next;
		}

	}

	public static void main(String...strings){
		CustomUnrolList<Integer> customUnrolList = new CustomUnrolList<>();
		customUnrolList.add(1);
		customUnrolList.add(2);
		customUnrolList.add(3);
		customUnrolList.add(4);
        customUnrolList.add(5);
        customUnrolList.add(6);
        customUnrolList.add(7);
        customUnrolList.add(8);
        customUnrolList.add(9);
        customUnrolList.add(10);

        
        customUnrolList.add(11);
		customUnrolList.add(12);
		customUnrolList.add(13);
		customUnrolList.add(14);
        customUnrolList.add(15);
        customUnrolList.add(16);
        customUnrolList.add(17);
        customUnrolList.add(18);
        customUnrolList.add(19);
        customUnrolList.add(20);
        customUnrolList.print();
        
		
	}
	
}
