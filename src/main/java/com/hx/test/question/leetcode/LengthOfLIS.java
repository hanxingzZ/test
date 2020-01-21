package com.hx.test.question.leetcode;

/**
 * 
 * @description: TODO
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2020年1月17日 下午6:04:43
 * @version 1.0
 */
public class LengthOfLIS {
	public static int lengthOfLIS(int[] nums) {
		int l = nums.length;
		if (l == 0) {
			return 0;
		}
		int dp[] = new int[l + 1];
		int res = 1;
		for (int i = 0; i < l; i++) {
			dp[i] = 1;
		}
		for (int i = 1; i < l; i++) {
			for (int j = 0; j < l; j++) {
				if (nums[j] > nums[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			res = Math.max(dp[i], res);
		}

		return res;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 9, 2, 5, 3, 7, 101, 18 };
		System.out.println(lengthOfLIS(arr));

	}

}
