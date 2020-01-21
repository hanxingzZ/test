package com.hx.test.question.leetcode;

public class FirstMissingPositive {
	public static int firstMissingPositive(int[] nums) {
		int l = nums.length;
		for (int i = 0; i < l; i++) {
			if (nums[i] >= 0 && nums[i] < l) {
				int temp = nums[nums[i]];
				nums[nums[i]] = nums[i];
				nums[i] = temp;
			}
		}
		for (int i = 0; i < l; i++) {
			if (nums[i] - 1 != i) {
				return i;
			}
		}

		return nums[l - 1] + 1;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 0 };
		int[] a1 = { 3, 4, -1, 1 };
		int[] a2 = { 7, 8, 9, 11, 12 };

		System.out.println(firstMissingPositive(a));
		System.out.println(firstMissingPositive(a1));
		System.out.println(firstMissingPositive(a2));
	}

}
