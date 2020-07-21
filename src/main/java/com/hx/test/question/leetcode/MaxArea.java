package com.hx.test.question.leetcode;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSON;

/**
 * 
 * @description: 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线
 *               i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 
 *               说明：你不能倾斜容器，且 n 的值至少为 2。
 * 
 * 
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年4月20日 上午9:29:00
 * @version 1.0
 */
public class MaxArea {

	public static int maxArea(int[] height) {
		int l = 0;
		int r = height.length - 1;
		int area = 1;
		while (l < r) {
			int temp = Math.min(height[l], height[r]) * (r - l);
			area = Math.max(area, temp);
			if (height[l] <= height[r]) {
				l++;
			} else {
				r--;
			}

		}

		return area;
	}

	public static void main(String[] args) {
		// String str = "{\n" +
		// "    \"orderId\": \"123\",\n" +
		// "    \"contractUrl\": \"456\",\n" +
		// "    \"userConfirmUrl\": \"789\",\n" +
		// "    \"contractInfo\": \"777\"\n" +
		// "}";
		// long l = System.currentTimeMillis();
		// System.out.println(l);
		// str = str + l + "hFjg#3$SsbeopC!Aci5^";
		// System.out.println(SecureUtil.md5(str));
		String str0 = new StringBuffer("ja1").append("va").toString();
		String str1 = new StringBuffer("ja").append("va").toString();
		String str2 = new StringBuffer("go").append("od").toString();
		String str3 = new StringBuffer("goa").append("od").toString();
		String str4 = new StringBuffer("Str").append("ing").toString();
		String str5 = new StringBuffer("ja").append("va").toString();
		String str6 = new StringBuffer("j").append("ava").toString();
		String str7 = new StringBuffer("java").toString();
		System.out.println(str0.intern() == str0);
		System.out.println(str1.intern() == str1);
		System.out.println(str2.intern() == str2);
		System.out.println(str3.intern() == str3);
		System.out.println(str4.intern() == str4);
		System.out.println(str5.intern() == str5);
		System.out.println(str6.intern() == str6);
		System.out.println(str7.intern() == str7);

	}

}
