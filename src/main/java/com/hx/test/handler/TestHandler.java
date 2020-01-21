package com.hx.test.handler;

public abstract class TestHandler {

	protected TestHandler testHandler;

	public TestHandler getTestHandler() {
		return testHandler;
	}

	public void setTestHandler(TestHandler testHandler) {
		this.testHandler = testHandler;
	}

	public abstract void getCount(int d);

	protected void next(int d) {
		if (testHandler != null) {
			testHandler.getCount(d);
		}
	}
}
