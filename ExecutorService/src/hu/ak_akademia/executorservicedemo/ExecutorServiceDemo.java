package hu.ak_akademia.executorservicedemo;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo {

	public static void main(String[] args) throws InterruptedException {
		for (int numberOfThreads = 1; numberOfThreads < 10; numberOfThreads++) {
			System.out.println("Használt szálak száma: " + numberOfThreads);
			ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
			Instant start = Instant.now();
			List<Future<Result>> futures = new ArrayList<>();
			for (long number = 1; number <= 1_000; number++) {
				long from = number * 1_000_000L;
				long to = (number + 1) * 1_000_000L;
				SumTask task = new SumTask(from, to);
				Future<Result> future = executor.submit(task);
				futures.add(future);
			}
//	          System.out.println("A feladatok ki lettek adva.");
			while (!futures.isEmpty()) {
				for (ListIterator<Future<Result>> iterator = futures.listIterator(); iterator.hasNext();) {
					Future<Result> future = iterator.next();
					if (future.isDone()) {
//	                  System.out.println("Eredmény: " + future.get());
						iterator.remove();
					}
				}
				Thread.sleep(10L);
			}
			executor.shutdown();
			executor.awaitTermination(1, TimeUnit.HOURS);
			Instant stop = Instant.now();
			Duration elapsedTime = Duration.between(start, stop);
			System.out.println("A kiszámoláshoz szükséges idő: " + elapsedTime.toMillis() + " ms.");
		}
		System.out.println("A program befejeződött.");
	}

}
