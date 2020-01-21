package com.hx.test.algorithmsanddatastructures.adt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;



public class QSwapListNode {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		for (Iterator<String> i = list.iterator(); i.hasNext();) {
			for (Iterator<String> j = list.iterator(); j.hasNext();) {
				System.out.println(i.next() + " " + j.next()); // i.next()和j.next()都会直接走向写一个元素
			}
		}


	}

}
