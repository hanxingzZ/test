package com.hx.test.java8.inaction.stream;

import java.util.Arrays;
import java.util.List;

import com.hx.test.java8.inaction.stream.pojo.Dish;
import com.hx.test.java8.inaction.stream.pojo.Trader;
import com.hx.test.java8.inaction.stream.pojo.Transaction;

public class Utils {
	private static List<Dish> dishes;

	private static List<Transaction> transactions;
	private Utils() {

	}
	
	
	public static List<Transaction> getTrabsactions(){
		if(transactions == null || transactions.isEmpty()){
			Trader raoul = new Trader("Raoul", "Cambridge"); 
			Trader mario = new Trader("Mario","Milan"); 
			Trader alan = new Trader("Alan","Cambridge"); 
			Trader brian = new Trader("Brian","Cambridge");
			transactions = Arrays.asList( 
					 new Transaction(brian, 2011, 300), 
					 new Transaction(raoul, 2012, 1000), 
					 new Transaction(raoul, 2011, 400), 
					 new Transaction(mario, 2012, 710), 
					 new Transaction(mario, 2012, 700), 
					 new Transaction(alan, 2012, 950) 
					);
		}
		
		return transactions;
	}
	public static List<Dish> getDemoDishes() {
		if(dishes == null || dishes.isEmpty()){
			dishes = Arrays.asList( 
					 new Dish("pork", false, 800, Dish.Type.MEAT), 
					 new Dish("beef", false, 700, Dish.Type.MEAT), 
					 new Dish("chicken", false, 400, Dish.Type.MEAT), 
					 new Dish("french fries", true, 530, Dish.Type.OTHER), 
					 new Dish("rice", true, 350, Dish.Type.OTHER), 
					 new Dish("season fruit", true, 120, Dish.Type.OTHER), 
					 new Dish("pizza", true, 550, Dish.Type.OTHER), 
					 new Dish("prawns", false, 300, Dish.Type.FISH), 
					 new Dish("salmon", false, 450, Dish.Type.FISH));
		}
	
		return dishes;
	}
}
