package com.hx.test.question.offer;

public class StrToInt {
	public static int strToInt(String str) {
		if (!isNum(str) || str.length() == 0) {
			return 0;
		}
		char[] c = str.toCharArray();
		int result = 0;
		int index = 1;
		for (int i = c.length - 1; i >= 0; i--) {
			if (i != 0) {
				result += (c[i] - 48) * index;
				index *= 10;
			} else {
				if (c[0] == '+') {
					break;
				} else if (c[0] == '-') {
					result = ~result + 1;
				} else {
					result += (c[i] - 48) * index;
				}
			}
			System.out.println(c[i] - 48 + "!!!!!result+i:" + i + "~~~:" + result);
		}

		return result;
	}

	private static boolean isNum(String str) {
		String reg = "^(-|\\+)?[0-9]*$";
		return str.matches(reg);
	}

	private static boolean isNum1(String str) {
		char[] c = new char[10];
		String str1 = new String(c);
		String reg = "^(-|\\+)?\\d*(\\.\\d+)?((e|E)(-|\\+)?\\d+)?$";
		return str.matches(reg);
	}

	public static void main(String[] args) {
		String str = "+2147483647";
		// System.out.println(strToInt(str));
		// System.out.println(isNum(str));
		// System.out.println(isNum("101212"));
		// System.out.println(strToInt("-123"));
		// System.out.println(isNum("-123"));
		System.out.println(isNum1("-1.5e21"));
	}
}
