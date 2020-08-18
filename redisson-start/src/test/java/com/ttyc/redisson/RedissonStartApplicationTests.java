package com.ttyc.redisson;

import org.junit.Test;

import java.util.TreeMap;

public class RedissonStartApplicationTests {

	@Test
	public void contextLoads() {

		TreeMap<Integer, String> map = new TreeMap<>();
		map.put(23, "sg");
		map.put(13, "he");
		map.put(42, "gh");
		map.put(15, "qt");
		map.put(8, "ox");
		map.put(3, "ps");

		Integer firstKey = map.tailMap(10).firstKey();
		System.out.println("firstKey = " + firstKey);

		Integer ceiling = map.ceilingEntry(10).getKey();
		System.out.println("ceiling = " + ceiling);

		for (int i = 0; i < 10; i++) {

			if(i==5){
				throw new RuntimeException();
			}
			System.out.println("i = " + i);
		}
	}


}
