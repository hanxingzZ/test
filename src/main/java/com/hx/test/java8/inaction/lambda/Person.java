package com.hx.test.java8.inaction.lambda;

public class Person {

	/**
	 * 组
	 */
	private String group;

	/**
	 * 性别
	 */
	private String gender;

	/**
	 * 名字
	 */
	private String name;

	public Person() {

	}

	public Person(String name) {
		this.name = name;
	}

	public Person(String group, String name) {
		this.group = group;
		this.name = name;
	}

	public Person(String group, String gender, String name) {
		this.group = group;
		this.gender = gender;
		this.name = name;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [group=" + group + ", gender=" + gender + ", name=" + name + "]";
	}

}
