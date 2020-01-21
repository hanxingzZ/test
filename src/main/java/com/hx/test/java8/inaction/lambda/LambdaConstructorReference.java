package com.hx.test.java8.inaction.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaConstructorReference {

	public static void main(String[] args) {

		// 无参构造
		Supplier<Person> s1 = Person::new;
		Person p11 = s1.get();
		Supplier<Person> s2 = () -> new Person();
		Person p12 = s2.get();
		System.out.println(p11);
		System.out.println(p12);
		// 一个参数构造
		Function<String, Person> f1 = Person::new;
		Person p21 = f1.apply("1个参数的对象1");
		Function<String, Person> f2 = (str) -> new Person(str);
		Person p22 = f2.apply("1个参数的对象2");
		System.out.println(p21);
		System.out.println(p22);
		// 两个参数构造
		BiFunction<String, String, Person> b1 = Person::new;
		Person p31 = b1.apply("2组", "2个参数的对象1");
		// 两个参数构造
		BiFunction<String, String, Person> b2 = (str1, str2) -> new Person(str1, str2);
		Person p32 = b2.apply("2组", "2个参数的对象2");
		System.out.println(p31);
		System.out.println(p32);
		// 三个参数构造，自定义接口
		TirFunction<String, String, String, Person> t1 = Person::new;
		Person p41 = t1.apply("3组", "男", "3个参数的对象1");
		TirFunction<String, String, String, Person> t2 = (str1, str2, str3) -> new Person(str1, str2, str3);
		Person p42 = t2.apply("3组", "男", "3个参数的对象2");
		System.out.println(p41);
		System.out.println(p42);
		StringBuffer sb = new StringBuffer();
	}

	interface TirFunction<T, U, V, R> {
		R apply(T t, U u, V v);
	}

}
