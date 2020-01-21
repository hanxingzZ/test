package com.hx.test.question.offer;

public class FindGreatestSumOfSubArray {
	public static int findGreatestSumOfSubArray(int[] array) {
		int sum = array[0];
		int tempsum = array[0];
		for (int i = 1; i < array.length; i++) {
			tempsum = tempsum + array[i] > array[i] ? tempsum + array[i] : array[i];
			sum = sum > tempsum ? sum : tempsum;
		}

		return sum;
	}

	public static void main(String[] args) {
		int[] arr = { 6, -3, -2, 7, -15, 1, 2, 2 };
		int[] arr1 = { -1, 1, -2, 3 };

		System.out.println(findGreatestSumOfSubArray(arr));
		System.out.println(findGreatestSumOfSubArray(arr1));

	}

}
