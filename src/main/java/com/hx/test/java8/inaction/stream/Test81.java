package com.hx.test.java8.inaction.stream;

public class Test81 {
	public static void doSomething(Runnable r) {
		r.run();
	}

	public static void doSomething(Task a) {
		a.execute();
	}

	public static void main(String[] args) {
		int a = 10;
		Runnable r1 = () -> {
			// int a = 2;
			System.out.println(a);
		};

		Runnable r2 = new Runnable() {

			@Override
			public void run() {
				int a = 2;
				System.out.println(a);

			}
		};
		doSomething(new Task() {
			public void execute() {
				System.out.println("Danger danger!!");
			}
		});
		//需明确指出调用哪个重载函数，可加强制类型
		// doSomething(() -> System.err.println(1));
		doSomething((Task) () -> System.out.println("Danger danger!!"));

	}

}

interface Task {
	public void execute();
}
