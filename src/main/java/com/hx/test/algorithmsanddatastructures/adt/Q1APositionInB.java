package com.hx.test.algorithmsanddatastructures.adt;

import java.util.ArrayList;

import java.util.List;
import java.util.ListIterator;

public class Q1APositionInB {

	public static void printLots(List<Integer> a, List<Integer> b) {
		ListIterator<Integer> listIterator = a.listIterator();
		while (listIterator.hasNext()) {
			int next = listIterator.next();
			System.out.println((next - 1 >= 0) && (next - 1 < b.size()) ? b.get(next - 1) : "无法输出第" + next + "个元素！");
		}

	}

	public static void main(String[] args) {
		List<Integer> a = new ArrayList<>();
		a.add(-1);
		a.add(1);
		a.add(3);
		a.add(4);
		a.add(6);
		a.add(8);
		a.add(100);
		List<Integer> b = new ArrayList<>();
		b.add(10);
		b.add(20);
		b.add(30);
		b.add(40);
		b.add(50);
		b.add(60);
		b.add(70);
		b.add(80);
		printLots(a, b);

	}
}
