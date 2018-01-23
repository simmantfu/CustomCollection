package com.custom.test;

import org.junit.Test;
import static org.junit.Assert.*;
import com.custom.*;
import com.custom.utils.*;

public class CustomHashMapTest {

	static CustomHashMap<Integer, String> customHashMap = new CustomHashMap<>();

	

	@Test
	public void testIterate() {
		int i = 0;
		for (Entity e : customHashMap) {
			i++;
		}
		
		
		assertSame(1000, i);
	}

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
		
		for(int i =0;i<1000;i++){
			customHashMap.add(i, "Test"+1);
		}
		
		int count = 0;
		
		for(Entity e : customHashMap){
			count++;
		}
		
		assertEquals(1000, count);
	}
	
}
