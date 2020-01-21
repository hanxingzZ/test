package com.hx.test.java8.inaction.stream.pojo;

/**
 * 交易员
 * 
 * @author xingh
 *
 */
public class Trader {

	/**
	 * 名称
	 */
	private final String name;

	/**
	 * 城市
	 */
	private final String city;

	public Trader(String n, String c) {
		this.name = n;
		this.city = c;
	}

	public String getName() {
		return this.name;
	}

	public String getCity() {
		return this.city;
	}

	@Override
	public String toString() {
		return "Trader [name=" + name + ", city=" + city + "]";
	}
}
