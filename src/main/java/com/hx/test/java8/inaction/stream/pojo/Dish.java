package com.hx.test.java8.inaction.stream.pojo;

import com.hx.test.java8.inaction.stream.Test62And63And64.CaloricLevel;

/**
 * @Description java8实战样例类--菜肴类
 * @author xingh
 *
 */
public class Dish {

	/**
	 * 名称
	 */
	private final String name;

	/**
	 * 荤素
	 */
	private final boolean vegetarian;

	/**
	 * 热量
	 */
	private final int calories;

	/**
	 * 类型
	 */
	private final Type type;

	public Dish(String name, boolean vegetarian, int calories, Type type) {
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public int getCalories() {
		return calories;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return name;
	}

	public enum Type {
		MEAT, FISH, OTHER
	}

	public static CaloricLevel groupByCalories(Dish dish) {
		if (dish.getCalories() <= 400) {
			return CaloricLevel.DIET;
		} else if (((Dish) dish).getCalories() <= 700) {
			return CaloricLevel.NORMAL;
		} else {
			return CaloricLevel.FAT;
		}
	}
}
