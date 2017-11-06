package com.custom;

public class CustomStack {

	private static int capacity = 10;
	private int top = -1;
	Object[] dataObjects;

	public CustomStack() {
		init(this.capacity);
	}

	public CustomStack(int initcapacity) {
		init(capacity);
	}

	private void init(int capacity) {
		this.capacity = capacity;
		dataObjects = new Object[this.capacity];
	}

	public void push(Object data) {
		if (this.top < this.capacity - 1) {
			this.top++;
			dataObjects[this.top] = data;
		} else {
			System.out.println("Stack overflow");
		}
	}

	public void pop() {
		if (this.top >= 0) {
			this.top--;
			dataObjects[this.top] = null;
		}
	}

	public int min() {

		int minimum = (int) dataObjects[0];
		for (int i = 0; i <= dataObjects.length - 1; i++) {

			// String work is in  progress
			//
			// if ((dataObjects[i]!=null && dataObjects[j]!=null
			// )&&((dataObjects[i].getClass().equals(String.class))
			// && (dataObjects[j].getClass().equals(String.class)))) {
			// String x = (String) dataObjects[i];
			// String y = (String) dataObjects[j];
			//
			// if (x.length() < y.length()) {
			// result = i;
			// }
			// }

			if ((dataObjects[i] != null) && ((dataObjects[i].getClass().equals(Integer.class)))) {
				int x = (int) dataObjects[i];

				if (x < minimum) {
					minimum = x;

				}

			}
		}
		return minimum;
	}

	public Object get(int index) {

		if (dataObjects[index] != null) {
			return dataObjects[index];
		} else {
			return null;
		}

	}
// This how stack will work
//	public static void main(String... ar) {
//
//		
//		// Add element 
//		CustomStack customStack = new CustomStack(50);
//		customStack.push(1);
//		customStack.push(10);
//		customStack.push(3);
//		customStack.push(2);
//		customStack.push(4);
//
//		// Get Minimum
//		System.out.println(customStack.min());
//
//		//Get by Index
//		System.out.println(customStack.get(1));
//		
//		// Delete Element
//		customStack.pop();
//	}

}
