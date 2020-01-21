package com.hx.test.question.leetcode;

public class Atoi {

	public static int myAtoi(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		str = str.trim();
		if (str.length() == 0) {
			return 0;
		}
		// sb1用来存原字符串，sb2用来存处理后转数字的字符串
		StringBuilder sb1 = new StringBuilder(str);
		StringBuilder sb2 = new StringBuilder();
		char c = sb1.charAt(0);
		boolean flag = false;
		// 首字符是1~9的数字加入到sb2中
		if ((c > '0' && c <= '9')) {
			flag = true;
			sb2.append(c);
			// 不是+-和0直接返回
		} else if (!(c == '+' || c == '-' || c == '0')) {
			return 0;
		}
		for (int i = 1; i < sb1.length(); i++) {
			char c1 = sb1.charAt(i);
			// 当不是数字的时候，直接退出循环
			if (!(c1 >= '0' && c1 <= '9')) {
				break;
			}
			// 当第一个不为0的字符出现才开始存入sb2
			if (c1 != '0') {
				flag = true;
			}
			if (flag) {
				sb2.append(c1);
			}
		}
		// 因为2^31为10位10进制，故当sb2大于10位时直接返回int边界值
		if (sb2.length() > 10) {
			return c == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		}
		// 此处用long不用考虑数值溢出问题
		long result = 0;
		long index = 1;
		// '0' = 48
		for (int i = sb2.length() - 1; i >= 0; i--) {
			char c2 = sb2.charAt(i);
			if (c == '-') {
				result += -(c2 - 48) * index;
			} else {
				result += (c2 - 48) * index;
			}
			index *= 10;
		}
		// 当result超过int的范围时返回int边界值
		if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
			return result < Integer.MIN_VALUE ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		}
		return (int) result;
	}

	public static void main(String[] args) {
		String s1 = "luzong";
		String s2 = "luzong";
		String s3 = new String("luzong");
		String s4 = new String("luzong");
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
		System.out.println(s3 == s4);
	}
}
