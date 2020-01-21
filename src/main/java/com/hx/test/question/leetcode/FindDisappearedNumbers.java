package com.hx.test.question.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list = new ArrayList<>();
		int index;
		for (int i = 0; i < nums.length; i++) {
			index = nums[i] - 1;
			while (index < 0) {
				index += nums.length;
			}
			nums[index] = nums[index] - nums.length;
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				list.add(i + 1);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		int[] arr = { 4, 3, 2, 7, 8, 2, 3, 1 };
		System.out.println(findDisappearedNumbers(arr));

	}

}
