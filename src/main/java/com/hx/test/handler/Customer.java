package com.hx.test.handler;

public class Customer {
	private TestHandler testHandler;

	public void setTestHandler(TestHandler testHandler) {
		this.testHandler = testHandler;
	}
	
	public void haggleCount(int d){
		testHandler.getCount(d);
	}
	
	
}
