package com.hx.test.thinkinjava.chapter5;

/**
 * 16.创建一个String数组，for循环打印数组
 * 17.创建一个类，它有一个接受一个string参数的构造器，在构造阶段打印该参数。创建一个类的数组，但不实际创建对象赋给该数组
 * 运行程序时观察构造信息是否打印 18.创建对象赋值给数组，完成17
 * 
 * @author xingh
 *
 */
public class Practise16to18 {

	public static void main(String[] args) {
		// 16
		String[] strArr = new String[] { "qaz", "wsx", "edc" };
		for (String str : strArr) {
			System.out.println(str);
		}
		// 17
		// Demo d1 = new Demo("hh");
		Demo[] dArr = new Demo[10];
		// 18
		Demo[] dArr1 = new Demo[] { new Demo(strArr[2]), new Demo(strArr[1]), new Demo(strArr[0]), };
	}

}

class Demo {

	private String str;

	Demo() {

	}

	Demo(String str) {
		this.str = str;
		System.out.println(str);
	}
}