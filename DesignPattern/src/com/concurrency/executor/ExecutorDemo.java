package com.concurrency.executor;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ExecutorService executor = Executors.newCachedThreadPool();

		Future<Integer> future = executor.submit(()-> {

				Random r = new Random();

				int duration = r.nextInt(4000);
				System.out.println("Thread Started");
				if (duration > 2000) {
					throw new IOException("Thread is thorws an exception");
				}
				Thread.sleep(duration);
				System.out.println("Thread finished");
				return duration;
			});

		//});
		executor.shutdown();

		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			IOException ext = (IOException) e.getCause();
			System.out.println(ext.getMessage());
		}
	}

}
