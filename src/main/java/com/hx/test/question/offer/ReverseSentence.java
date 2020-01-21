package com.hx.test.question.offer;

public class ReverseSentence {

	public static String reverseSentence(String str) {
		if (str.trim().length() == 0) {
			return str;
		}
		char[] c = str.toCharArray();
		reversal(c, 0, c.length - 1);
		int index = 0;
		int next = 0;
		int begin = 0;
		while (index < c.length - 1) {

			if (c[index] != ' ') {
				next++;
			} else {
				reversal(c, begin, next - 1);
				begin = index + 1;
				next = begin;

			}
			index++;
		}
		reversal(c, begin, c.length - 1);
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
		String str = "student. a am I";
		System.out.println(reverseSentence(str));

	}

}
