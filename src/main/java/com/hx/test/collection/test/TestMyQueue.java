package com.hx.test.collection.test;

import java.util.ArrayList;
import java.util.List;

import com.hx.test.collection.queue.MyQueue;

public class TestMyQueue {

	public static void main(String[] args) {
		MyQueue<Integer> myQueue = new MyQueue<>();
		for (int i = 0; i < 10; i++) {
			myQueue.inQueue(i);
		}

		while(!myQueue.isEmpty()) {
			System.out.println(myQueue.peek() + "  " + myQueue.outQueue());
		}
		List<Integer> list= new ArrayList<>();
		list.add(1);
		List<Integer> list1 = list.subList(0, 1);
		System.out.println(list1.size());
		
		
	}

}
