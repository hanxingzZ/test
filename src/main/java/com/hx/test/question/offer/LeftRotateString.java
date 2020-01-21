package com.hx.test.question.offer;

public class LeftRotateString {

	public static String leftRotateString(String str, int n) {
		if (str.length() == 0) {
			return str;
		}
		n %= str.length();
		StringBuilder sb1 = new StringBuilder(str.substring(0, n));
		StringBuilder sb2 = new StringBuilder(str.substring(n, str.length()));
		return sb2.append(sb1).toString();
	}

	public static String leftRotateString1(String str, int n) {
		if (str.length() == 0) {
			return str;
		}
		n %= str.length();
		char[] c = str.toCharArray();
		reversal(c, 0, n - 1);
		reversal(c, n, c.length - 1);
		reversal(c, 0, c.length - 1);

		return new String(c);
	}

	private static void reversal(char[] c, int begin, int end) {
		while (begin <= end) {
			char t = c[end];
			c[end] = c[begin];
			c[begin] = t;
			begin++;
			end--;
		}
	}

	public static void main(String[] args) {
		String str = "132ASCVQ";
		System.out.println(leftRotateString(str, 3));
		System.out.println(leftRotateString1(str, 3));

	}

}
