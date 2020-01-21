package com.hx.test.algorithmsanddatastructures.sort.util;

public class SortUtils {

	public static void swap(int[] arr, int i, int j) {
		arr[i] ^= arr[j];
		arr[j] ^= arr[i];
		arr[i] ^= arr[j];
	}

	public static void main(String[] args) {

		int[] arr = { 3, 2, 1 };
		swap(arr, 0, 1);
		for (int a : arr) {
			System.out.println(a);
		}
	}
}
