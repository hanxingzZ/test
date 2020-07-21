package com.hx.test.question.hxtest;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年7月7日 下午3:58:41
 * @version 1.0
 */
public class Q50_duplicate {
	// Parameters:
	// numbers: an array of integers
	// length: the length of array numbers
	// duplication: (Output) the duplicated number in the array number,length of
	// duplication array is 1,so using duplication[0] = ? in implementation;
	// Here duplication like pointor in C/C++, duplication[0] equal *duplication
	// in C/C++
	// 这里要特别注意~返回任意重复的一个，赋值duplication[0]
	// Return value: true if the input is valid, and there are some duplications
	// in the array number
	// otherwise false
	public static boolean duplicate(int numbers[], int length, int[] duplication) {
		if (numbers == null || length == 0) {
			return false;
		}
		for (int i = 0; i < length; i++) {
			int index = numbers[i] % length;

			if (numbers[index] >= length) {
				duplication[0] = index;
				System.out.println(duplication[0]);
				return true;
			}
			numbers[index] += length;
		}
		System.out.println(duplication[0]);
		return false;
	}

	public static void main(String[] args) {
		
	}
}