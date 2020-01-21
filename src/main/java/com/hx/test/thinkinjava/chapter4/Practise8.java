package com.hx.test.thinkinjava.chapter4;

public class Practise8 {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			switch (i % 3) {
			case 0:
				System.out.println(i + "%3=0");
			case 1:
				System.out.println(i + "%3=1");
			default:
				System.out.println("break");
				break;

			}

		}
	}

}
