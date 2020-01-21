package com.hx.test.question.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @description: 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 
 *               例如，给定三角形：
 * 
 *               [ [2], [3,4], [6,5,7], [4,1,8,3] ]
 *               自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2020年1月14日 上午11:11:09
 * @version 1.0
 */
public class MinimumTotal {
	public static int minimumTotal(List<List<Integer>> triangle) {
		int row = triangle.size();
		int[] dp = new int[row + 1];
		for (int i = row - 1; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
			}
		}
		return dp[0];
	}

	public static void main(String[] args) {

		List<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(2));
		list.add(Arrays.asList(3, 4));
		list.add(Arrays.asList(6, 5, 7));
		list.add(Arrays.asList(4, 1, 8, 3));
		
		System.out.println(minimumTotal(list));

	}
}
