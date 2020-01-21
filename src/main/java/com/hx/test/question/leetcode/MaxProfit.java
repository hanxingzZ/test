package com.hx.test.question.leetcode;

/**
 * 
 * @description: 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 
 *               设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 
 *               注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2020年1月9日 上午10:41:20
 * @version 1.0
 */
public class MaxProfit {
	public static int maxProfit(int[] prices) {
		int sum = 0;
		for (int i = 1; i < prices.length; i++) {
			int t = 0;
			if ((t = prices[i] - prices[i - 1]) > 0) {
				sum += t;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[] { 7, 1, 5, 3, 6, 4 }));

	}
}
