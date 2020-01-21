package com.hx.test.question.leetcode;

public class MaxSubArray {

	public static int maxSubArray(int[] nums) {
		int sum = nums[0];
		int tempSum = 0;
		for (int a : nums) {
			tempSum = tempSum + a > a ? tempSum + a : a;
			sum = tempSum > sum ? tempSum : sum;
		}
		return sum;
	}

	public static void main(String[] args) {
		// int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		// int[] arr1 = { -2 };
		// // System.out.println(maxSubArray(arr));
		// System.out.println(maxSubArray(arr1));
		String str = "(/w/d)*58.com";
		String str1 = "test58.com";
		System.out.println(str1.matches(str));
	}

}
