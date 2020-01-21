package com.hx.test.thinkinjava.chapter5;

import static com.hx.test.thinkinjava.utils.Utils.print;

;

/**
 * 14.编写一个类，拥有两个静态字符串域，一个再定义处初始化，一个静态块初始化，证明在使用前已经完成初始化
 * 
 * @author xingh
 *
 */
public class Practise13to14 {

	static char c;

	public static void main(String[] args) {
		print("main()");
		// // Cups.cup1.f(99);
		// Cups cups1 = new Cups();
		New n = new New();
		System.out.println(n);
		New.print1();
		System.out.println(c + 0);

	}

	Cups cups1 = new Cups();
	// static Cups cups1 = new Cups();
	// static Cups cups2 = new Cups();

}

class New {

	static String str1 = "1hh";
	static String str2;

	static {
		str2 = "2hh";
	}

	static void print1() {
		print(str1 + "~~~~" + str2);
	}

	@Override
	public String toString() {
		return "New [toString()=str1:" + str1 + ",str2" + str2 + "]";
	}
}

class Cup {
	Cup(int marker) {
		print("Cup(" + marker + ")");
	}

	void f(int marker) {
		print("f(" + marker + ")");
	}
}

class Cups {
	static Cup cup1;
	static Cup cup2;
	static {
		cup1 = new Cup(1);
		cup2 = new Cup(2);
	}

	Cups() {
		print("Cups()");
	}
}