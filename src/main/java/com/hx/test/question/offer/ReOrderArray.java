package com.hx.test.question.offer;

/**
 * 
 * @description: 
 *               输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数
 *               ，偶数和偶数之间的相对位置不变。
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2019年12月7日 下午4:37:25
 * @version 1.0
 */
public class ReOrderArray {

	public static void reOrderArray(int[] array) {
		int[] arr = new int[array.length];
		System.arraycopy(array, 0, arr, 0, array.length);
		int index1 = 0;
		int length = arr.length;
		int index2 = length - 1;
		for (int i = 0; i < length; i++) {
			if ((arr[i] & 1) == 1) {
				array[index1++] = arr[i];
			}
		}
		for (int i = length - 1; i >= 0; i--) {
			if ((arr[i] & 1) == 0) {
				array[index2--] = arr[i];
			}
		}

	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7, 2, 4, 6 };
		reOrderArray(arr);
		for (int a : arr) {
			System.out.println(a);
		}

	}

}
