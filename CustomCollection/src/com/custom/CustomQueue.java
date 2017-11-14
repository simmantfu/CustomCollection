package com.custom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomQueue<V> implements Iterable<V> {

	Object[] dataObject;
	private static final int INIT_CAPACITY = 10;
	private int front, rear, start, end,entrycount;

	public CustomQueue() {
		init(INIT_CAPACITY);
	}

	public CustomQueue(int capacity) {
		init(capacity);
	}

	private void init(int capacity) {
		dataObject = new Object[capacity];
		front = rear = -1;
		start = entrycount= 0;
		end = dataObject.length - 1;
	}

	public void enqueue(V data) {
		if (rear < dataObject.length) {
			rear++;
			dataObject[rear] = data;
		}
	}

	public void dequeue() {
		if (front < dataObject.length) {
			front++;
			dataObject[front] = null;
		}
	}

	public V get(int index) {
		if (dataObject[index] != null) {
			return (V) dataObject[index];
		}
		return null;
	}

	public void display() {

		for (int i = 0; i < dataObject.length; i++) {
			if (dataObject[i] != null)
				System.out.println(dataObject[i]);

		}

	}

	@Override
	public Iterator<V> iterator() {
		// TODO Auto-generated method stub
		return new CustomQueueItr();
	}

	class CustomQueueItr implements Iterator<V> {

		private int cursor;

		CustomQueueItr() {
			this.cursor = CustomQueue.this.start;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return this.cursor <= CustomQueue.this.end;
		}

		@Override
		public V next() {
			// TODO Auto-generated method stub
			if (this.hasNext()) {
				int current = cursor;
				cursor++;
				return (V) dataObject[current];
			}
			throw new NoSuchElementException();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CustomQueue<String> customQueue = new CustomQueue<>();
		customQueue.enqueue("simmant");
		customQueue.enqueue("sonu");
		customQueue.enqueue("vik");

		for (String s : customQueue)
			System.out.println(s);
	}

}
