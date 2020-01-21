package com.hx.test.question.util;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int val) {
		this.val = val;

	}

	public static int minNumberInRotateArray(int[] array) {
		int l = array.length;
		if (l == 0) {
			return 0;
		}

		int begin = 0;
		int end = l - 1;
		if (array[begin] < array[end]) {
			return array[begin];
		}
		while (begin < end) {

			int mid = begin + (end - begin) / 2;

			if (array[mid] > array[begin]) {
				begin = mid;
			} else if (array[mid] < array[end]) {
				end = mid;
			} else {
				begin++;
			}
		}
		return array[end];
	}

	public static void main(String[] args) {
		int[] arr = new int[1000000];
		int[] arr1 = { 7, 1, 2, 3, 4, 5, 6 };
		int[] arr2 = { 99, -100, -1, 3 };
		int[] arr3 = { 0 };
		int[] arr4 = {};
		for (int i = 6; i < 1000000; i++) {
			arr[i - 6] = i;
		}

		arr[999994] = 1000000;
		arr[999995] = 1;
		arr[999996] = 2;
		arr[999997] = 3;
		arr[999998] = 4;
		arr[999999] = 5;

		System.out.println(minNumberInRotateArray(arr));
		System.out.println(minNumberInRotateArray(arr1));
		System.out.println(minNumberInRotateArray(arr2));
		System.out.println(minNumberInRotateArray(arr3));
		System.out.println(minNumberInRotateArray(arr4));

	}
}
