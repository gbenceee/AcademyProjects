package hu.ak_akademia.primecheck;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceCheckPrime {
	private static final int NUMBER_OF_THREADS = 4;
	private static final int NUMBER_OF_TASKS = 1_000;

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Instant start = Instant.now();
		long number = 126_478_323L;
//	      long interval = number / NUMBER_OF_TASKS;
		long interval = (long) Math.ceil((double) number / NUMBER_OF_TASKS);
		ExecutorService executor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
		List<Future<Result>> futures = new ArrayList<>();
		for (int i = 0; i < NUMBER_OF_TASKS; i++) {
			long from = Math.max(2, i * interval);
			long to = Math.min(number, (i + 1) * interval);
//	          System.out.println("from: " + from + "; to: " + to);
			DivisorCheckerTask task = new DivisorCheckerTask(number, from, to);
			Future<Result> future = executor.submit(task);
			futures.add(future);
		}
		List<Result> results = new ArrayList<>();
		for (Future<Result> future : futures) {
			Result result = future.get();
			results.add(result);
		}
		boolean prime = true;
		for (Result result : results) {
			if (result == Result.HAS_DIVISOR) {
				prime = false;
			}
		}
		System.out.println(prime ? "prím" : "összetett szám");
		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.HOURS);
		Instant stop = Instant.now();
		Duration elapsedTime = Duration.between(start, stop);
		System.out.println("Eltelt idő: " + elapsedTime.toMillis() + " ms.");
	}

}
