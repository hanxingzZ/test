package com.hx.test.question.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @description: 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。 例如，给出 n =
 *               3，生成结果为： [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * 
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2020年1月10日 下午2:09:12
 * @version 1.0
 */
public class GenerateParenthesis {
	public List<String> generateParentheses(int n) {
		List<String> list = new ArrayList<>();
		gernrateenerateParenthesByOne("", list, n, n);
		return list;
	}

	private void gernrateenerateParenthesByOne(String str, List<String> result, int left, int right) {
		if (left == 0 && right == 0) {
			result.add(str);
			return;
		}
		if (left > 0) {
			gernrateenerateParenthesByOne(str + "(", result, left - 1, right);
		}
		if (right > left) {
			gernrateenerateParenthesByOne(str + ")", result, left, right - 1);
		}

	}

	public static void main(String[] args) {
		GenerateParenthesis g = new GenerateParenthesis();
		System.out.println(g.generateParentheses(3));

	}

}
