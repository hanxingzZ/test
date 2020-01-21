package com.hx.test.handler;

public class Manager extends TestHandler {

	@Override
	public void getCount(int d) {
		if (d >= 100 && d < 200) {
			System.out.println("经理同意降价" + d);
		}
		super.next(d);

	}

}
