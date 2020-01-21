package com.hx.test.question.leetcode;

import java.util.Stack;

public class EvalRPN {
	public static int evalRPN(String[] arr) {
		Stack<String> stack = new Stack<>();

		for (String str : arr) {
			if (isNum(str)) {
				stack.push(str);
			} else {
				if(stack.size()<2){
					return 0;
				}
				String str1 = stack.pop();
				String str2 = stack.pop();
				stack.push(mathOperation(str2, str1, str));
			}
		}
		return Integer.parseInt(stack.pop());
	}

	private static boolean isNum(String str) {
		String reg = "^-?[0-9]+(.[0-9]+)?$";
		return str.matches(reg);
	}

	private static String mathOperation(String str1, String str2, String operator) {
		int result = 0;
		int i1 = Integer.valueOf(str1);
		int i2 = Integer.valueOf(str2);
		switch (operator) {
		case "+":
			result = i1 + i2;
			break;
		case "-":
			result = i1 - i2;
			break;
		case "*":
			result = i1 * i2;
			break;
		case "/":
			result = i1 / i2;
			break;
		}
		return String.valueOf(result);
	}

	public static void main(String[] args) {
		String[] arr =  { "2", "1", "+", "3" };
		String[] arr1 = { "4", "13", "5", "/", "+" };
		String[] arr2 = { "3", "-4", "+" };
		System.out.println(evalRPN(arr));
		System.out.println(evalRPN(arr1));
		System.out.println(evalRPN(arr2));

	}

}
