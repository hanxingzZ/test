package com.hx.test.juc.semaphore;

public class Test {
	double b;

	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "abc";
		String str3 = new String("abc");
		String str4 = new String("abc");

		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		System.out.println(str3 == str4);
		int a = 1;
		System.out.println(a + 0.0);

		System.out.println(new Test().b);
		System.out.println(240/15/24.0);
	}

}
