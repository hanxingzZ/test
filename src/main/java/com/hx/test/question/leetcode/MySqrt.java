package com.hx.test.question.leetcode;

/**
 * 
 * @description: 实现 int sqrt(int x) 函数。
 * 
 *               计算并返回 x 的平方根，其中 x 是非负整数。
 * 
 *               由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2020年1月10日 下午4:03:39
 * @version 1.0
 */
public class MySqrt {

	public int mySqrt(int x) {
		if (x == 0 || x == 1) {
			return x;
		}
		int left = 0, right = x;
		int res = x;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (mid == x / mid) {
				return mid;
			} else if (mid < x / mid) {
				left = mid + 1;
			} else {
				right = mid - 1;
				res = right;
			}
		}
		return res;
	}

	public static double sqrt(double x) {
		if (x == 0 || x == 1) {
			return x;
		}
		double l = 0, r = x;
		while (r - l > 1e-9) {
			double mid = (l + r) / 2;
			if(mid == x / mid){
				return mid;
			}else if (mid < x / mid) {
				l = mid;
			} else {
				r = mid;
			}
		}
		return l;
	}

	public static void main(String[] args) {
		System.out.println(sqrt(15));
		System.out.println(Math.sqrt(15));
	}

}
