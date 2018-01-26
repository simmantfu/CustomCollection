package com.custom.test;

import java.util.HashMap;
import java.util.Map;

import com.custom.utils.Entity;

public class PlayArea {

	static Map<Integer, String> m = new HashMap<>();

	// static CustomSynchronizedHashMap<Integer, String> m = new
	// CustomSynchronizedHashMap<>();
	// static CustomHashMap<Integer, String> m = new CustomHashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// m = Collections.synchronizedMap(m);
		int value = 0;
		int lastValue = 1000;
		for (int i = 0; i <= 100; i++) {

			Thread d = new Thread(new T1(value, lastValue));
			d.start();

			value = lastValue + 1;
			lastValue = lastValue + 1000;
		}
		for (int i = 0; i <= 100; i++) {
			Thread d2 = new Thread(new T2());

			d2.start();
		}

	}

	static class T1 implements Runnable {

		int i, end;

		T1(int i, int end) {
			this.i = i;
			this.end = end;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			for (int j = this.i; j <= this.end; j++) {
				m.put(j, "test" + j);
			}
		}

	}

	static class T2 implements Runnable {

		@Override
		public void run() {

			// for (Entity e : m) {
			//
			// System.out.println(e.key);
			//
			// }

			// for (Map.Entry<Integer, String> e : m.entrySet()) {
			//
			// System.out.println(e.getKey());
			//
			// }

			for (int i = 0; i <= 1000; i++) {
				System.out.println(m.get(i));
			}
			//
		}

	}

}
