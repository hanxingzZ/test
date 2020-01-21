package com.hx.test.question.leetcode;

import java.util.HashMap;

/**
 * 
 * @description: 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 
 *               你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 
 * 
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2020年1月2日 下午2:46:19
 * @version 1.0
 */
public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[] { map.get(target - nums[i]), i };
			}
			map.put(nums[i], i);
		}

		return null;
	}

	public static void main(String[] args) {
		int[] nums = { 5, 5, 11, 15 };
		for (int a : twoSum(nums, 10)) {
			System.out.println(a);
		}

	}

}
