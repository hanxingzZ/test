package com.hx.test.question.offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Q5moreNum {

	public static int moreNum(int[] array) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : array) {
			if (map.get(i) == null) {
				map.put(i, 1);
			} else {
				map.put(i, map.get(i) + 1);
			}
		}
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > array.length / 2) {
				return entry.getKey();
			}
		}

		return 0;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
		long s = System.currentTimeMillis();
		System.out.println(moreNum(arr));
		System.out.println(System.currentTimeMillis()-s);

	}

}
