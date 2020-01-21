package com.hx.test.algorithmsanddatastructures.sort;

import com.hx.test.algorithmsanddatastructures.sort.util.SortUtils;

public class HSort {

	public static void sort(int[] arr) {
		int l = arr.length;
		for (int i = l / 2 - 1; i >= 0; i--) {
			adjustMaxHeap(arr, i, l - 1);
		}

		for (int i = l - 1; i > 0; i--) {
			SortUtils.swap(arr, 0, i);
			adjustMaxHeap(arr, 0, i - 1);
		}
	}

	private static void adjustMaxHeap(int[] arr, int cur, int l) {
		int temp = arr[cur];
		for (int i = 2 * cur + 1; i <= l; i = i * 2 + 1) {
			if (i < l && arr[i] < arr[i + 1]) {
				i += 1;
			}
			if (temp > arr[i]) {
				break;
			}
			arr[cur] = arr[i];
			cur = i;
		}
		arr[cur] = temp;
	}

	public static void main(String[] args) {
		int[] arr = { 0, 50, 10, 90, 30, 70, 40, 80, 600, 20, 2000, 1 };
		sort(arr);
		

	}

}
