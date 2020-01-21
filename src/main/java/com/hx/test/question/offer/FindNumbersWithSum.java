package com.hx.test.question.offer;

import java.util.ArrayList;

public class FindNumbersWithSum {
	public ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
		ArrayList<Integer> list = new ArrayList<>();
		int begin = 0;
		int end = array.length - 1;
		int count = 999999999;
		while (begin < end) {
			if (array[begin] + array[end] > sum) {
				end--;
			} else if (array[begin] + array[end] < sum) {
				begin++;
			} else {
				if (count > (array[begin] * array[end])) {
					count = array[begin] * array[end];
					list.add(0, array[begin]);
					list.add(1, array[end]);
				}
				begin++;
			}
		}

		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
