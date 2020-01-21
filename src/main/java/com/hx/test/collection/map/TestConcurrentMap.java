package com.hx.test.collection.map;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentMap {
	private static ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
	// private static HashMap<String, Integer> map = new HashMap<>();
	private static String KEY = "hh";

	public static void add(String key) {
		if (map.get(key) != null) {
			map.put(key, map.get(key) + 1);
			System.out.println(map.get(key));
		} else {
			map.put(key, 1);
		}
	}

	private static class TestThread implements Runnable {
		@Override
		public void run() {
			synchronized (KEY) {
				add(KEY);
			}

		}
	}

	public static void main(String[] args) {
		map.clear();
		for (int i = 0; i < 10000; i++) {
			Thread tt = new Thread(new TestThread());
			tt.start();
		}
	}

}
