package com.hx.test.handler;

import java.util.Random;

public class Test {
	public static TestHandler createhandler() {
		TestHandler market = new Market();
		TestHandler manager = new Manager();
		TestHandler boss = new Boss();
		market.setTestHandler(manager);
		manager.setTestHandler(boss);
		return market;
	}

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.setTestHandler(createhandler());
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			// double b =Math.random()*1000;
			int b = random.nextInt(1000);
			System.out.println("顾客" + i + "：我想便宜" + b);
			customer.haggleCount(b);
			System.out.println("~~~~~~~~~~~~~~");
		}
	}

}
