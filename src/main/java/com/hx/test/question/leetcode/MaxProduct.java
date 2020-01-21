package com.hx.test.question.leetcode;


/**
 * 
 * @description: 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2020年1月14日 下午5:10:23
 * @version 1.0
 */
public class MaxProduct {
	public static int maxProduct(int[] nums) {

		int dpMax = nums[0];
		int dpMin = nums[0];
		int max = dpMax;
		for (int i = 1; i < nums.length; i++) {
			int preMax = dpMax;
			dpMax = Math.max(Math.max(nums[i] * dpMin, nums[i]), nums[i] * dpMax);
			dpMin = Math.min(Math.min(nums[i] * dpMin, nums[i]), nums[i] * preMax);
			max = Math.max(max, dpMax);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] arr1 = { -2, 0, -1 };
		System.out.println(maxProduct(arr1));

	}

}
