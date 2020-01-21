package com.hx.test.question.offer;


public class GetRepeatingNum {
	public static boolean duplicate(int numbers[], int length, int[] duplication) {

		for (int i = 0; i < length; i++) {
			if (duplication[numbers[i]] < 1) {
				duplication[numbers[i]]++;
			} else {
				duplication[0] = numbers[i];
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 1, 3, 1, 4 };
		int l = 7;
		int[] arr1 = new int[7];
		System.out.println(duplicate(arr, l, arr1));

	}

}
