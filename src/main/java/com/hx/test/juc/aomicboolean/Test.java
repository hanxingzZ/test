package com.hx.test.juc.aomicboolean;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) throws ParseException {
		// double d = 123.456;
		// long l = Double.doubleToLongBits(d);
		// System.out.println(l);
		// DoubleAdder dou = new DoubleAdder();
		// dou.add(d);
		// dou.add(d);
		// System.out.println(Double.longBitsToDouble(l + l));
		// System.out.println(dou.toString());
		List<DemoClass> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			DemoClass d = new DemoClass();
			d.setId(Long.valueOf(i));
			d.setAge(i + 20);
			d.setName("name" + i);
			d.setBirthday(new Date(System.currentTimeMillis() - i * 60 * 60 * 24 * 30 * 1000));
			list.add(d);
		}
		DemoClass d = new DemoClass();
		d.setId(Long.valueOf(0));
		d.setAge(220);
		d.setName("name" + 0);
		d.setBirthday(new Date(System.currentTimeMillis() - 0 * 60 * 60 * 24 * 30 * 1000));
		list.add(d);

		// guava list转map
		// Map<Long, DemoClass> map = Maps.uniqueIndex(list, new
		// Function<DemoClass, Long>() {
		// @Override
		// public Long apply(DemoClass de) {
		// return de.getId();
		// }
		// });
		List<Long> ids = Arrays.asList(1L, 4L);
		Map<Long, DemoClass> map = new HashMap<>();
		map = list.stream().filter(demo -> !ids.contains(demo.getId()))
				.collect(Collectors.toMap(DemoClass::getId, Function.identity(), (key1, key2) -> key2));

		map.forEach((k, v) -> {
			System.out.print("key:" + k);
			System.out.print(" ");
			System.out.println("value:" + v);
		});
		String a = "a";
		System.out.println("a" + a == "a" + "a");
	}

}
