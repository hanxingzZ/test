package com.hx.test.algorithmsanddatastructures.sort;

public class QuickSort {

	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	private static void quickSort(int[] arr, int low, int high) {
		if (low < high) {
			int index = getIndex(arr, low, high);
			quickSort(arr, low, index - 1);
			quickSort(arr, index + 1, high);

		}
	}

	private static int getIndex(int[] arr, int low, int high) {
		int t = arr[low];
		while (low < high) {
			while (arr[high] >= t && low < high) {
				high--;
			}

			arr[low] = arr[high];
			while (arr[low] <= t && low < high) {
				low++;
			}
			arr[high] = arr[low];

		}
		arr[low] = t;
		return low;
	}

	public static void main(String[] args) {
		// int[] arr = { 34, 8, 64, 51, 32, 21, 1 };
		// int[] arr1 = { 5, 4, 3, 2, 1 };
		// int[] arr2 = {};
		// int[] arr3 = { 1 };
		// quickSort(arr);
		// quickSort(arr1);
		// quickSort(arr2);
		// quickSort(arr3);
		// for (int a : arr) {
		// System.out.print(a + " ");
		// }
		// System.out.println();
		// for (int a : arr1) {
		// System.out.print(a + " ");
		// }
		// System.out.println();
		// for (int a : arr2) {
		// System.out.print(a + " ");
		// }
		// System.out.println();
		// for (int a : arr3) {
		// System.out.print(a + " ");
		// }
		
	}

}
