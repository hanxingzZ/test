package com.hx.test.question.offer;

import java.util.Stack;

public class PopOrder {
	public static boolean isPopOrder(int[] pushA, int[] popA) {
		if (pushA.length == 0 || popA.length == 0) {
			return false;
		}
		Stack<Integer> stack = new Stack<>();
		int temp = 0;
		for (int i = 0; i < pushA.length; i++) {
			stack.push(pushA[i]);
			while (!stack.empty() && stack.peek() == popA[temp]) {
				temp++;
				stack.pop();
			}
		}
		return stack.empty();
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		int[] arr1 = { 4, 5, 3, 2, 1 };
		int[] arr2 = { 4, 3, 5, 1, 2 };
		System.out.println(isPopOrder(arr, arr1));
		System.out.println(isPopOrder(arr, arr2));

	}

}
