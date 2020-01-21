package com.hx.test.java8.inaction.stream.pojo;

/**
 * 交易记录
 * 
 * @author xingh
 *
 */
public class Transaction {

	/**
	 * 交易员
	 */
	private final Trader trader;

	/**
	 * 时间
	 */
	private final int year;

	/**
	 * 金额
	 */
	private final int value;

	public Transaction(Trader trader, int year, int value) {
		this.trader = trader;
		this.year = year;
		this.value = value;
	}

	public Trader getTrader() {
		return this.trader;
	}

	public int getYear() {
		return this.year;
	}

	public int getValue() {
		return this.value;
	}

	public String toString() {
		return "{" + this.trader + ", " + "year: " + this.year + ", " + "value:" + this.value + "}";
	}
}
