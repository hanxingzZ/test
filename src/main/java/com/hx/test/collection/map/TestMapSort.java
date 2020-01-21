package com.hx.test.collection.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class TestMapSort {

	public static void sortMapValue(Map<String, String> map) {
		// 这里将map.entrySet()转换成list
		List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
		// 然后通过比较器来实现排序
		Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
			// 升序排序
			public int compare(Entry<String, String> o1, Entry<String, String> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}

		});

		for (Map.Entry<String, String> mapping : list) {
			System.out.println("value排序：" + mapping.getKey() + ":" + mapping.getValue());
		}
	}
	 public static List<String> sortMapByValue(Map<String, String> map) {
	        int size = map.size();
	        List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(size);
	        list.addAll(map.entrySet());
	        List<String> keys = list.stream()
	                .sorted(Comparator.comparing(Map.Entry<String, String>::getValue).reversed())
	                .map(Map.Entry<String, String>::getKey)
	                .collect(Collectors.toList());
	        return keys;
	    }


	public static void main(String[] args) {
		Map<String, String> map = new TreeMap<String, String>();
		map.put("d", "ddddd");
		map.put("b", "bbbbb");
		map.put("a", "aaaaa");
		map.put("c", "ccccc");
		map.put("a1", "a1");
		map.put("a2", "a2");
		// sortMapValue(map);
		sortMapByValue(map).forEach(System.out::println);

	}
}
