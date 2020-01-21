package com.hx.test.java8.inaction.stream;

public class Test94 {

	public static void main(String[] args) {
		Test t = new Test();
		Test1 t1 = new Test1();
		Test2 t2 = new Test2();
		t.hello();
		t1.hello();
		t2.hello();
		int i = 0;
	}

}

interface A {
	default void hello() {
		System.out.println("A ");
	}
}

interface B extends A {
	default void hello() {
		System.out.println("B ");
	}
}

interface C {
	default void hello() {
		System.out.println("C ");
	}
}

class D implements A {
	public void hello() {
		System.out.println("D ");
	}
}

class Test extends D implements A, B {

}

class Test1 implements A, B {

}

class Test2 implements A, C {
	public void hello() {
		C.super.hello();
	}
}
