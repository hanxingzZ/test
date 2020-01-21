package com.hx.test.question.offer;

public class Q6count1ten {

	public static int count1(int n) {
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i <= n; i++) {
			sb.append(i);
		}
		System.out.println(sb.toString());
		int count = 0;
		for (int i = 0; i < sb.length(); i++) {
			if (sb.charAt(i) == '1') {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(count1(13));

	}

}
