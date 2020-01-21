package com.hx.test.question.leetcode;

/**
 * 
 * @description: 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1
 *               的数目并将它们作为数组返回。
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2020年1月13日 下午4:13:24
 * @version 1.0
 */
public class CountBits {
	/**
	 * 低位有效 状态转移方程 f(x) = f(x/2)+x%2
	 */
	public static int[] countBits(int num) {
		int[] nums = new int[num + 1];
		for (int i = 0; i <= num; i++) {
			nums[i] = nums[i >> 1] + (i & 1);
		}

		return nums;
	}
	
	public static int[] countBits1(int num) {
		int[] nums = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			nums[i] = nums[i & (i - 1)] + 1;
		}

		return nums;
	}

	public static void main(String[] args) {

		for (int a : countBits(5)) {
			System.out.print(a + " ");
		}
		System.out.println();
		for (int a : countBits1(5)) {
			System.out.print(a + " ");
		}

	}

}
