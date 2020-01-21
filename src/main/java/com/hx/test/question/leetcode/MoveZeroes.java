package com.hx.test.question.leetcode;

public class MoveZeroes {
	public static void moveZeroes(int[] nums) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				swap(nums, i, index++);
			}
		}

	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 3, 12 };
		moveZeroes(arr);
		for (int a : arr) {
			System.out.print(a + " ");
		}

	}

}
