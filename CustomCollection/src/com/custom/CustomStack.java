package com.custom;

import java.util.Iterator;

public class CustomStack<T> implements Iterable<T> {

	private static int capacity = 10;
	private int top = -1;
	Object[] dataObjects, dataObjects2;

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
			dataObjects2 = new Object[this.top + 1];
			System.arraycopy(dataObjects, 0, dataObjects2, 0, this.top + 1);
		} else {
			System.out.println("Stack overflow");
		}
	}

	public Object pop() {

		Object obj = null;

		if (this.top >= 0) {
			obj = dataObjects[this.top];
			dataObjects[this.top] = null;
			this.top--;
			dataObjects2 = new Object[this.top + 1];
			System.arraycopy(dataObjects, 0, dataObjects2, 0, this.top + 1);

		}

		return obj;
	}

	public int min() {

		int minimum = (int) dataObjects[0];
		for (int i = 0; i <= dataObjects.length - 1; i++) {

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

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new StackIt<T>();
	}

	private class StackIt<T> implements Iterator<T> {

		int tempCount = 0;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return this.tempCount < dataObjects2.length;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			if (hasNext()) {
				int temp = this.tempCount;
				this.tempCount++;
				Object obj = dataObjects2[temp];
				return (T) obj;
			}

			return null;
		}

	}

	public static void main(String... ar) {

		// Add element
		CustomStack<Integer> customStack = new CustomStack<Integer>(50);
		customStack.push(1);
		customStack.push(10);
		customStack.push(3);
		customStack.push(2);
		customStack.push(4);
		customStack.push(6);

		// Get Minimum
		// System.out.println(customStack.min());

		System.out.println("pre print");
		for (int k : customStack) {

			System.out.println(k);
		}

		customStack.pop();
		customStack.pop();
		System.out.println("post print");
		for (int k : customStack) {

			System.out.println(k);
		}

	}

}
