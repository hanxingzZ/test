package com.hx.test.question.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @description: TODO
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2020年1月8日 下午4:24:37
 * @version 1.0
 */
public class MajorityElement {
	private Integer result;

	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>(nums.length / 2);
		for (int a : nums) {
			map.put(a, map.getOrDefault(a, 0) + 1);
		}
		map.forEach((k, v) -> {
			if (v > nums.length / 2) {
				this.result = k;
			}
		});
		return result;
	}

	public int majorityElement1(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
