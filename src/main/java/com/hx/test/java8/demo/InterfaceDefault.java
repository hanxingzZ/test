package com.hx.test.java8.demo;

import java.util.Comparator;

/**
 * 接口的静态方法和默认方法 
 */
public class InterfaceDefault {

	// 包含默认方法的接口
	interface defaultMethodInterface {
		default void defaultMethod() {
			System.out.println(" I'm default method! ");
		}
	}

	// 包含静态方法的接口
	interface staticMethodInterface {
		static void staticMethod() {
			System.out.println(" I'm a static method in a interface!");
		}
	}

	public static void main(String[] args) {
		// java 6 我们创建比较器的方法
		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(), o2.length());
			}
		};

		// 可以用lambda 表达式这么来写
		Comparator<String> comparator1 = (String a, String b) -> {
			return Integer.compare(a.length(), b.length());
		};

		// | 上式也完全可以用这句来代替
		// ↓ comparing 方法就是 Comparator 的静态方法
		Comparator<String> comparator2 = Comparator.comparing(String::length);

		System.out.println(comparator2.compare("s10000", "11111111111"));
		;

		// 同样的例子还有很多
	}
}
