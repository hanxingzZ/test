package com.hx.test.juc.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	public static void main(String[] args) {
		// 模拟5个停车位，10辆车去抢车位
		// Semaphore内部包含公平锁（FairSync）和非公平锁（NonfairSync）默认为非公平锁
		Semaphore semaphore = new Semaphore(5);
		// 模拟10辆汽车
		for (int i = 1; i <= 10; i++) {
			new Thread(() -> {
				try {
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName() + "\t抢到车位");
					Thread.sleep(3000);
					System.out.println(Thread.currentThread().getName() + "\t停车3秒后,离开车位");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					semaphore.release();
				}
			}, i + "").start();
		}

	}

}
