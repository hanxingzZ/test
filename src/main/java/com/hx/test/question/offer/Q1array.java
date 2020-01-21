package com.hx.test.question.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 *
 */
public class Q1array {

	public static boolean Find(int target, int[][] matrix) {

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

	public static boolean Find1(int target, int[][] array) {
		int length = 0;
		int index = array[0].length - 1;
		while (length < array.length - 1 && index > 0) {
			if (array[length][index] > target) {
				index--;
			} else if (array[length][index] < target) {
				length++;
			} else {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] array = { { 1, 2, 3 }, { 8, 9, 10 }, { 15, 20, 25 } };
		int[][] arr1 = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		// System.out.println(Find(9, array));
		System.out.println(Find1(9, array));
		System.out.println(Find1(7, arr1));

	}

}
