package com.hx.test.handler;

public class Boss extends TestHandler {

	@Override
	public void getCount(int d) {
		if (d >= 200 && d <= 500) {
			System.out.println("老板同意了降价" + d);
		}
		if (d > 500) {
			System.out.println("老板：你滚犊子吧");
		}
		super.next(d);
	}
}
