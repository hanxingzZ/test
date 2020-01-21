package com.hx.test.algorithmsanddatastructures.sort;

import java.util.Arrays;

public class MergeSort {

	public static void mergeSort(int[] arr) {
		int[] temp = new int[arr.length];
		mergeSort(arr, 0, arr.length - 1, temp);
	}

	private static void mergeSort(int[] arr, int low, int high, int[] temp) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(arr, low, mid, temp);
			mergeSort(arr, mid + 1, high, temp);
			merge(arr, low, mid, high, temp);
		}
	}

	private static void merge(int[] arr, int low, int mid, int high, int[] temp) {
		int left = low;
		int right = mid + 1;
		int t = 0;
		while (left <= mid && right <= high) {
			if (arr[left] >= arr[right]) {
				temp[t++] = arr[right++];
			} else {
				temp[t++] = arr[left++];
			}
		}
		while (left <= mid) {
			temp[t++] = arr[left++];
		}
		while (right <= high) {
			temp[t++] = arr[right++];
		}
		t = 0;
		while (low <= high) {
			arr[low++] = temp[t++];
		}

	}

	public static void main(String[] args) {
		int[] arr = { 34, 8, 64, 51, 32, 21, 1 };
		int[] arr1 = { 5, 4, 3, 2, 1 };
		int[] arr2 = {};
		int[] arr3 = { 1 };
		mergeSort(arr);
		mergeSort(arr1);
		mergeSort(arr2);
		mergeSort(arr3);
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
		for (int a : arr1) {
			System.out.print(a + " ");
		}
		System.out.println();
		for (int a : arr2) {
			System.out.print(a + " ");
		}
		System.out.println();
		for (int a : arr3) {
			System.out.print(a + " ");
		}
	}

}
