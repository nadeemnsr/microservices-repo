package com.multithreading.concept;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueDemo {

	public static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

	public static void main(String[] args) throws InterruptedException {

		Thread t1 = new Thread(() -> {
			try {
				producer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		Thread t2 = new Thread(() -> {
			try {
				consumer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();

	}

	private static void producer() throws InterruptedException {
		Random r = new Random();
		while (true) {
			
			queue.put(r.nextInt(100));
		}

	}

	private static void consumer() throws InterruptedException {
		Random r = new Random();
		while (true) {
			Thread.sleep(500);
			if (r.nextInt(10) == 0) {
				System.out.println("taking queue : " + queue.take());
			}
		}
	}
}