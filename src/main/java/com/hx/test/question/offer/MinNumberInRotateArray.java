package com.hx.test.question.offer;

/**
 * 
 * @description: 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *               输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 *               例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *               NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2019年12月5日 下午7:20:56
 * @version 1.0
 */
public class MinNumberInRotateArray {
	public static int minNumberInRotateArray(int[] array) {

		int length = array.length;
		if (length == 0) {
			return 0;
		}
		int begin = 0;
		int end = length - 1;

		while (begin < end) {
			int mid = begin + (end - begin) / 2;
			if (array[mid] > array[begin]) {
				begin = mid;

			} else if (array[mid] < array[end]) {
				end = mid;
			} else {
				begin++;
			}
		}
		return array[end];
	}

	public static void main(String[] args) {
		int[] arr = { 3, 4, 5, 1, 2 };
		System.out.println(minNumberInRotateArray(arr));

	}

}
