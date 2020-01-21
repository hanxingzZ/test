package com.hx.test.question.leetcode;

public class SearchMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {

		// 二维数组的行数
		int r = matrix.length;
		if (r == 0) {
			return false;
		}
		// 二维数组的列数数
		int l = matrix[0].length;
		if (l == 0) {
			return false;
		}
		int i = r - 1;
		int j = 0;
		while (i > 0 && j < l) {

			if (matrix[i][j] > target) {
				i--;
				j = 0;
			} else if (matrix[i][j] < target) {
				j++;
			} else {
				return true;
			}
		}
		int length = matrix.length - 1;
		int count = 0;
		while (length >= 0 && count < matrix[0].length) {
			if (matrix[length][count] > target) {
				length--;
			} else if (matrix[length][count] < target) {
				count++;
			} else {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		try {
			System.out.println(10 / 0);
		} catch (Throwable e) {
			System.out.println(e.getMessage());
		}

	}

}
