package com.hx.test.thinkinjava.chapter5;

/**
 * 19.写一个接受可变参数的方法，验证可以向该方法传递一个逗号分割的string列表或者一个string数组
 * 21.创建一个enum，包含纸币中最小面值的6种类型，通过values()循环并打印每一个值及其ordinal方法
 * 
 * @author xingh
 *
 */
public class Practise19to22 {

	public static void fun(String... args) {
		for (String arg : args) {
			System.out.println(arg);
		}
	}

	public static void main(String[] args) {
		// 19
		fun("132", "232");
		fun(new String[] { "232", "231" });

		// 21&22
		for (Money m : Money.values()) {
			System.out.print(m + ":" + m.ordinal() + " ");
			switch (m) {
			case HUNDRED:
				System.out.println("￥" + 100);
				break;
			case FIFTY:
				System.out.println("￥" + 50);
				break;
			case TWENTY:
				System.out.println("￥" + 20);
				break;
			case TEN:
				System.out.println("￥" + 10);
				break;
			case FIVE:
				System.out.println("￥" + 5);
				break;
			case TWO:
				System.out.println("￥" + 2);
				break;
			case ONE:
				System.out.println("￥" + 1);
				break;
			default:
				break;
			}
		}
	}
}

enum Money {
	ONE, TWO, FIVE, TEN, TWENTY, FIFTY, HUNDRED
}
