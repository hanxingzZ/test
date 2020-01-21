package com.hx.test.question.offer;
/**
 * 
 * 计算二进制数1的个数
 *
 */
public class Q4count1two {

	public static void main(String[] args) {
		int n = 298;
		int a = 0;
		for (int i = 0; i < 32; i++) {
			System.out.println((n & (1 << i)) + "~" + (1 << i));
			if ((n & (1 << i)) == (1 << i)) {
				a++;
			}
		}
		System.out.println(a);
		// long s2 = System.currentTimeMillis();
		// int count = 0;
		// while (n != 0) {
		// n = n & (n - 1);
		// ++count;
		// }
		//
		// System.out.println(count);

	}

}
