package com.hx.test.question.offer;

public class FindMax {

	public static int findmax(int[] array) {
		int l = array.length;
		if (l == 0) {
			return 0;
		}

		int begin = 0;
		int end = l - 1;
		while (begin < end) {
			int mid = begin + (end - begin) / 2;

			if (array[mid] > array[begin]) {
				begin = mid + 1;
			} else if (array[mid] < array[end]) {
				end = mid;
			} else if (array[mid] == array[end]) {
				begin = mid - 1;
			}
		}

		return array[begin];
	}

	public static void main(String[] args) {
		int[] arr = { 6501, 6828, 6963, 7036, 7422, 7674, 8146, 8468, 8704, 8717, 9170, 9359, 9719, 9895, 9896, 9913,
				9962, 154, 293, 334, 492, 1323, 1479, 1539, 1727, 1870, 1943, 2383, 2392, 2996, 3282, 3812, 3903, 4465,
				4605, 4665, 4772, 4828, 5142, 5437, 5448, 5668, 5706, 5725, 6300, 6335 };
		int[] arr1 = { 3, 4, 5, 1, 2 };

		System.out.println(findmax(arr1));
		System.out.println(findmax(arr));
	}
}
