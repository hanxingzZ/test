package com.hx.test.question.offer;

public class Q10getNumberOfK {

	public static int getNumberOfK(int[] array, int k) {
		int start = 0, end = array.length - 1;
		int t = -1;
		int mid;
		int count = 0;
		while (start <= end) {
			mid = (start + end) / 2;
			if (array[mid] > k) {
				end = mid - 1;
			} else if (array[mid] < k) {
				start = mid + 1;
			} else if (array[mid] == k) {
				t = mid;
				break;
			}
		}
		if (t == -1)
			return 0;

		int t1 = t;
		int t2 = t;

		while (t1 > 0) {
			if (array[--t1] == k)
				count++;
			else
				break;
		}
		while (t2 < array.length - 1) {
			if (array[++t2] == k)
				count++;
			else
				break;
		}

		return count + 1;
	}

	public static void main(String[] args) {

		int[] arr = { 0, 0, 0, 10, 10, 10, 25, 30, 30, 30, 30, 30, 30, 30, 30 };
		int[] arr1 = {};
		int[] arr2 = { 3 };
		int[] arr3 = { 3, 3, 3, 3 };
		int[] arr4 = new int[100000000];
		

		long s = System.currentTimeMillis();
		System.out.println(getNumberOfK(arr4, 5));
		long s1 = System.currentTimeMillis();
		System.out.println(s1 - s);

	}

}
