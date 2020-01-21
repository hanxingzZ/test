package com.hx.test.algorithmsanddatastructures.sort;

public class InsertSort {

	public static void insertSort(int[] arr) {
		int length = arr.length;
		int i = 1;

		while (i < length) {
			int temp = i;
			for (int j = temp; j > 0; j--) {
				if (arr[temp] >= arr[temp - 1]) {

					break;
				} else if (arr[temp] < arr[temp - 1]) {
					int t = arr[temp];
					arr[temp] = arr[temp - 1];
					arr[temp - 1] = t;
					temp--;
				}

			}
			i++;
		}
	}

	public static void main(String[] args) {
		int[] arr = { 34, 8, 64, 51, 32, 21, 1 };
		int[] arr1 = { 5, 4, 3, 2, 1 };
		int[] arr2 = {};
		int[] arr3 = { 1 };
		insertSort(arr1);
		insertSort(arr);
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
