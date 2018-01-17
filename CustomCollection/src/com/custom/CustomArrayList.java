package com.custom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomArrayList<V> implements Iterable<V> {

	private static final int INIT_CAPACITY = 10;
	Object[] objects,obj1;
	private int pointer = 0;
	private int start = 0, end;

	public CustomArrayList() {
		// TODO Auto-generated constructor stub
		init(INIT_CAPACITY);
	}

	public CustomArrayList(int capacity) {
		init(capacity);
	}

	private void init(int capacity) {
		objects = new Object[capacity];
		end = objects.length - 1;
	}

	public void add(Object obj) {
		if (pointer <= objects.length - 1) {
			objects[pointer] = obj;
			pointer++;
		}else{
			obj1 = objects;
			objects = new Object[obj1.length*2];
			System.arraycopy(obj1, 0, objects,0, this.pointer);
			end = objects.length - 1;
		}
	}

	public V get(int index) {
		if (objects[index] == null || objects == null) {
			return null;
		} else {
			V data = (V) objects[index];

			return data;
		}
	}

	public void remove(int index) {
		if (objects[index] != null || objects != null) {
			System.arraycopy(objects, index+1, objects, index+1, this.pointer-index-1);
		} else {
			System.out.println("Not a valid");
		}
	}

	public void set(int index, Object data) {
		if (objects[index] != null || objects != null) {
			objects[index] = data;
		} else {
			System.out.println("Not a valid");
		}
	}

	@Override
	public Iterator<V> iterator() {
		// TODO Auto-generated method stub
		return new CustomIterator();
	}

	class CustomIterator implements Iterator<V> {
		private int cursor;

		public CustomIterator() {
            this.cursor = CustomArrayList.this.start;
        }
		
		public boolean hasNext(){
			
			if(objects[cursor]!=null){
				return true;
			}else{
				return false;
			}
			
		}
		
		 public V next() {
	            if(this.hasNext()) {
	                int current = cursor;
	                cursor ++;
	                return (V) objects[current];
	            }
	            throw new NoSuchElementException();
	        }
		
		

	}
	
	public static void main(String... strings) {
		CustomArrayList<Integer> arrayList = new CustomArrayList<>();
		for (int i = 0; i < 15; i++) {
			arrayList.add(i);
		}

		arrayList.remove(10);
		
		for(int a:arrayList){
			System.out.println(a);
		}
		
		
//		for (int i = 0; i < 15; i++) {
//			System.out.println(arrayList.get(i));
//		}
//
//		arrayList.remove(10);
//
//		for (int i = 0; i < 15; i++) {
//			System.out.println(arrayList.get(i));
//		}
//
//		arrayList.set(0, 10);
//
//		for (int i = 0; i < 15; i++) {
//			System.out.println(arrayList.get(i));
//		}
	}

	

}
