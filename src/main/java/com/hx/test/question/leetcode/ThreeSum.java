package com.hx.test.question.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @description: TODO
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2020年1月2日 下午3:51:08
 * @version 1.0
 */
public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			int temp = nums[i];
			if (temp > 0) {
				break;
			}
			if (i > 0 && temp == nums[i - 1]) {
				continue;
			}
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				int sum = temp + nums[start] + nums[end];
				if (sum == 0) {
					ArrayList<Integer> list = new ArrayList<>();
					list.add(temp);
					list.add(nums[start]);
					list.add(nums[end]);
					result.add(list);

					while (start < end && nums[end] == nums[end - 1]) {
						end--;
					}
					end--;

					while (start < end && nums[start] == nums[start + 1]) {
						start++;
					}
					start++;
				} else if (sum > 0) {

					while (start < end && nums[end] == nums[end - 1]) {
						end--;
					}
					end--;
				} else {

					while (start < end && nums[start] == nums[start + 1]) {
						start++;
					}
					start++;
				}

			}
		}
		return result;
	}

	public static List<List<Integer>> threeSum1(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for (int k = 0; k < nums.length - 2; k++) {
			if (nums[k] > 0)
				break;
			if (k > 0 && nums[k] == nums[k - 1])
				continue;
			int i = k + 1, j = nums.length - 1;
			while (i < j) {
				int sum = nums[k] + nums[i] + nums[j];
				if (sum < 0) {
					while (i < j && nums[i] == nums[++i])
						;
				} else if (sum > 0) {
					while (i < j && nums[j] == nums[--j])
						;
				} else {
					res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
					while (i < j && nums[i] == nums[++i])
						;
					while (i < j && nums[j] == nums[--j])
						;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {

		System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
		System.out.println(threeSum(new int[] { 0, 0, 0, 0 }));
		System.out.println(threeSum(new int[] { 1, -1, -1, 0 }));
		System.out.println(threeSum(new int[] { -2, 0, 1, 1, 2 }));
		System.out.println(threeSum1(new int[] { -1, 0, 1, 2, -1, -4 }));
		System.out.println(threeSum1(new int[] { 0, 0, 0, 0 }));
		System.out.println(threeSum1(new int[] { 1, -1, -1, 0 }));
		System.out.println(threeSum1(new int[] { -2, 0, 1, 1, 1, 2 }));

	}

}
