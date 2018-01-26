package com.custom.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Objects;

import org.junit.Test;

import com.custom.map.CustomHashMap;
import com.custom.utils.Entity;

public class CustomHashMapTest {

	static CustomHashMap<Integer, String> customHashMap = new CustomHashMap<>();

	@Test
	public void testIterateUnExpected() {
		int i = 0;
		for (Entity e : customHashMap) {
			i++;
		}
		assertFalse("not actual count", i != 1000);
	}

	@Test
	public void testGet() {
		assertEquals("Test1", customHashMap.get(1));
	}

	@Test
	public void testGetWithNull() {
		assertEquals(null, customHashMap.get(1003));
	}

	@Test
	public void testAddThousandValues() {

		for (int i = 0; i < 1000; i++) {
			customHashMap.add(i, "Test" + 1);
		}

		int count = 0;

		for (Entity e : customHashMap) {
			if (Objects.nonNull(e)) {
				int a = (int) e.key;
				String b = (String) e.value;

				// System.out.println(a +""+b);
			}
			count++;
		}

		assertEquals(1000, count);
	}

}
