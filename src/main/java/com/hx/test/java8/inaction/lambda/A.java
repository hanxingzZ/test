package com.hx.test.java8.inaction.lambda;

import java.util.UUID;
import java.util.function.BiFunction;

import com.hx.test.java8.inaction.lambda.LambdaConstructorReference.TirFunction;

public class A {

	public static void main(String[] args) {

		BiFunction<String, String, Integer> b = B::ss;

		BiFunction<String, String, Integer> b1 = (s1, s2) -> B.ss(s1, s2);
		

		TirFunction<B, String, String, Integer> s = B::ss1;
		TirFunction<B, String, String, Integer> st = (bb, s1, s2) -> bb.ss1(s1, s2);
		for(int i =0 ;i<5;i++){
			
			System.out.println(UUID.randomUUID().toString());
		}
	}

}
