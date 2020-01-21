package com.hx.test.java8.inaction.stream;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @description: TODO
 * @author : 韩兴(13039997950@163.com)
 * @date 创建时间：2019年12月2日 下午3:17:58
 * @version 1.0
 */
public class Test82ObserverTest {

	/**
	 * 
	 * Description: TODO
	 * 
	 * @author 韩兴（13039997950@163.com）
	 * @date 2019年12月2日 下午3:19:22
	 * @version 1.0
	 */
	interface Observer {
		void notify(String tweet);
	}

	class NYTimes implements Observer {
		public void notify(String tweet) {
			if (tweet != null && tweet.contains("money")) {
				System.out.println("Breaking news in NY! " + tweet);
			}
		}
	}

	class Guardian implements Observer {
		public void notify(String tweet) {
			if (tweet != null && tweet.contains("queen")) {
				System.out.println("Yet another news in London... " + tweet);
			}
		}
	}

	class LeMonde implements Observer {
		public void notify(String tweet) {
			if (tweet != null && tweet.contains("wine")) {
				System.out.println("Today cheese, wine and news! " + tweet);
			}
		}
	}

	/**
	 * 
	 * Description: TODO
	 * 
	 * @author 韩兴（13039997950@163.com）
	 * @date 2019年12月2日 下午3:19:29
	 * @version 1.0
	 */
	interface Subject {
		void registerObserver(Observer o);

		void notifyObservers(String tweet);
	}

	class Feed implements Subject {
		private final List<Observer> observers = new ArrayList<>();

		public void registerObserver(Observer o) {
			this.observers.add(o);
		}

		public void notifyObservers(String tweet) {
			observers.forEach(o -> o.notify(tweet));
		}
	}

	public static void main(String[] args) {
		Test82ObserverTest os = new Test82ObserverTest();
		Feed f = os.new Feed();
		f.registerObserver(os.new NYTimes());
		f.registerObserver(os.new Guardian());
		f.registerObserver(os.new LeMonde());
		f.notifyObservers("The queen said her favourite book is Java 8 in Action!");
	}
}
