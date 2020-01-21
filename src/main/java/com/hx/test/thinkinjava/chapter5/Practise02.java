package com.hx.test.thinkinjava.chapter5;

/**
 * 定义时初始化数据和构造器初始化数据
 * 
 * @author xingh
 *
 */
public class Practise02 {

	public String str1 = "1";

	public String str2;

	Practise02(String str2) {
		this.str2 = str2;
	}

	// 静态>普通 代码块>构造器
	{
		System.out.println(str1);
		System.out.println(str2);
	}

	public static void main(String[] args) {
		Practise02 p2 = new Practise02("12");

	}

}
