package com.hx.test.algorithmsanddatastructures.sort;

import com.hx.test.algorithmsanddatastructures.sort.util.SortUtils;

public class BubbleSort {

	public static void bubbleSort(int[] arr) {
		int l = arr.length;
		for (int i = 0; i < l; i++) {
			for (int j = i + 1; j < l; j++) {
				if (arr[i] > arr[j]) {
					SortUtils.swap(arr, i, j);
				}
			}
		}
	}

	public static void bubbleSort1(int[] arr) {
		int l = arr.length;
		for (int i = 0; i < l; i++) {
			for (int j = l - 1; j > i; j--) {
				if (arr[j - 1] > arr[j]) {
					SortUtils.swap(arr, j - 1, j);
				}
				for (int a : arr) {
					System.out.print(a + " ");
				}
				System.out.println();
			}

		}
	}

}
