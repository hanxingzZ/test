package com.hx.test.java8.inaction.stream;

import java.time.LocalDate;

/** 
 * 
 * @description: TODO
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2019年12月3日 上午11:05:53 
 * @version 1.0   
 */
public class Test121 {

	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2020, 12, 3);
		System.out.println(date.getYear());
		System.out.println(date.getMonth());
		System.out.println(date.getDayOfMonth());
		System.out.println(date.getDayOfWeek());
		System.out.println(date.lengthOfMonth());
		System.out.println(date.isLeapYear()); 
		

	}

}
