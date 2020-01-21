package com.hx.test.question.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * Description: 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author 韩兴（13039997950@163.com）
 * @date 2019年12月30日 上午10:44:05
 * @version 1.0
 */
public class ValidParentheses {
	public boolean isValid(String s) {
		if (s == null) {
			return true;
		}
		char[] cArr = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < cArr.length; i++) {
			if (isLeft(cArr[i])) {
				stack.push(cArr[i]);
			} else if (stack.isEmpty() || !isMatch(stack.pop(), cArr[i])) {
				return false;
			}

		}
		return stack.empty();
	}

	private boolean isLeft(char c) {
		return c == '(' || c == '{' || c == '[';
	}

	private boolean isMatch(char c1, char c2) {
		return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}') || (c1 == '[' && c2 == ']');
	}

	public boolean isValid1(String s) {
		if (s == null) {
			return true;
		}
		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		char[] cArr = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < cArr.length; i++) {
			if (!map.containsKey(cArr[i])) {
				stack.push(cArr[i]);
			} else if (stack.isEmpty() || !stack.pop().equals(map.get(cArr[i]))) {
				return false;
			}

		}
		return stack.empty();
	}

	public boolean isValid2(String s) {
		if (s == null) {
			return true;
		}
		char[] cArr = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < cArr.length; i++) {
			if (isLeft(cArr[i])) {
				stack.push(cArr[i]);
			} else if (stack.isEmpty() || !isMatch(stack.pop(), cArr[i])) {
				return false;
			}

		}
		return stack.empty();
	}

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException {
		String s = "()";
		String s1 = "()[]{}";
		String s2 = "(]";
		String s3 = "([)]";
		String s4 = "{[]}";
		ValidParentheses a = new ValidParentheses();
		System.out.println(a.isValid(s));
		System.out.println(a.isValid(s1));
		System.out.println(a.isValid(s2));
		System.out.println(a.isValid(s3));
		System.out.println(a.isValid(s4));

		System.out.println(a.isValid1(s));
		System.out.println(a.isValid1(s1));
		System.out.println(a.isValid1(s2));
		System.out.println(a.isValid1(s3));
		System.out.println(a.isValid1(s4));
		Class<ValidParentheses> vc = ValidParentheses.class;
		Class<? extends ValidParentheses> vc1 = new ValidParentheses().getClass();
		Class<?> vc2 = Class.forName("leetCode.ValidParentheses");
		System.out.println(vc.equals(vc2));
		System.out.println(vc1.equals(vc2));

	}

}
