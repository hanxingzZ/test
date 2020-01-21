package com.hx.test.java8.demo;

import java.util.Random;
import java.util.function.DoubleSupplier;


public class HelloLambda {

	/*
	 * lambda 表达式的格式： 参数、箭头 ->，以及一个表达式。 如果负责计算的代码无法用一个表达式表示，
	 * 那么可以用编写方法的方式来编写：即用{}包裹代码并明确使用return语句
	 */

	public static void main(String args[]) {
		HelloLambda tester = new HelloLambda();

		// -------------有参数有返回值----------
		// 带有类型声明的表达式
		MathOperation addition = (int a, int b) -> a + b;
		// 没有类型声明的表达式
		MathOperation subtraction = (a, b) -> a - b;
		// 带有大括号、带有返回语句的表达式
		MathOperation multiplication = (int a, int b) -> {
			int i = a * b;
			return i;
		};
		// 没有大括号和return语句的表达式
		MathOperation division = (int a, int b) -> a / b;

		// 输出结果
		System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
		System.out.println("100 - 5 = " + tester.operate(100, 5, subtraction));
		System.out.println("10 x 50 = " + tester.operate(10, 50, multiplication));
		System.out.println("20 / 5 = " + tester.operate(20, 5, division));

		// -------------有参数无返回--------------------
		GreetingService greetService1 = message -> System.out.println("Hello " + message);

		GreetingService greetService2 = (message) -> System.out.println("Hello " + message);

		// 调用sayMessage方法输出结果
		greetService1.sayMessage("ChengDu");
		greetService2.sayMessage("RepeatLink");

		// -------------无参数有返回
		for (int i = 0; i < 10; i++) {
			GetRandom random = () -> Math.random() * 10;
			System.out.println(random.getRandom());
		}
	}

	// 下面是定义的一些接口和方法

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

	interface MathOperation {
		int operation(int a, int b);
	}

	interface GreetingService {
		void sayMessage(String message);
	}

	interface GetRandom {
		double getRandom();
	}
}