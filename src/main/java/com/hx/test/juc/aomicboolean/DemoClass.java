package com.hx.test.juc.aomicboolean;

import java.util.Date;

public class DemoClass {

	/**
	 * id
	 */
	private Long id;

	/**
	 * 年龄
	 */
	private Integer age;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 生日
	 */
	//@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", age=" + age + ", name=" + name + ", birthday=" + birthday + "]";
	}
}
