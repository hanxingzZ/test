package com.hx.test.collection.map;

import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		String key = "key1123123dasd";
		for (int i = 0; i < 16; i++) {
			map.put(key + i, "value" + i);
		}
		int a = 10;
		System.out.println(a++ + a--);
		map.get(key);
		System.out.println(map.get(key));
		System.out.println("!!!!!");
		int h;
		System.out.println(key.hashCode());
		System.out.println((h = key.hashCode()) ^ (h >>> 16));
		System.out.println(Integer.toBinaryString(key.hashCode()));
		System.out.println(Integer.toBinaryString(h >>> 16));
		System.out.println(Integer.toBinaryString(h ^ (h >>> 16)));
		Double d = 100.0;
		char s1 = '\u0639';

	}
}
