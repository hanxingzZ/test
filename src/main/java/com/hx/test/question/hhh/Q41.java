package com.hx.test.question.hhh;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @description: TODO
 * @author : 韩兴(xing.han@ucarinc.com)
 * @date 创建时间：2020年7月9日 下午4:06:58
 * @version 1.0
 */
public class Q41 {
	public List<List<Integer>> findSum(int sum) {
		List<List<Integer>> result = new ArrayList<>();
		int start = 1;
		int end = 2;
		while (start < end) {
			int s = (start + end) * (end - start + 1) / 2;
			if (s == sum) {
				List<Integer> list = new ArrayList<>();
				list.add(start);
				list.add(end);
				result.add(list);
				start++;
			} else if (s < sum) {
				end++;

			} else {
				start++;
			}
		}

		return result;
	}
}
