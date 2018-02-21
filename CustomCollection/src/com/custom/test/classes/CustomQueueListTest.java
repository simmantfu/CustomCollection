package com.custom.test.classes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.custom.CustomQueueList;

public class CustomQueueListTest implements TestImportInterface {

	static CustomQueueList<Integer> customQueueList = new CustomQueueList<>();

	@Before
	@Override
	public void setUp() {
		customQueueList.enqueue(1);
		customQueueList.enqueue(2);
		customQueueList.enqueue(3);
		customQueueList.enqueue(4);
		customQueueList.enqueue(5);
		customQueueList.enqueue(6);
		customQueueList.enqueue(7);

	}

	@Test
	public void sizeTest() {

		assertTrue(customQueueList.size() == 7);

	}

	@Test
	public void getTest() {

		assertTrue(customQueueList.get(5) != null);

	}

	@Test
	public void dequeueTest() {
		int data = customQueueList.dequeue();
		assertEquals("Data after dequeue", 1, data);
		assertEquals("Size after dequeue", 6, customQueueList.size());
	}

	@Test
	public void iterationTest() {

		int i = 0;

		Iterator<Integer> it = customQueueList.iterator();

		while (it.hasNext()) {
			it.next();
			i++;

		}

		assertEquals("IterationTest", i, customQueueList.size());
	}

	@After
	@Override
	public void tearDown() {
		customQueueList.clear();
	}

}
