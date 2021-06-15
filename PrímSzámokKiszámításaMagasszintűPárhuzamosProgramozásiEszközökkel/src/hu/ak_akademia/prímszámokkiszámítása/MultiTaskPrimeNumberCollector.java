package hu.ak_akademia.prímszámokkiszámítása;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiTaskPrimeNumberCollector {

	private int numberOfTasks;
	private int numberOfThreads;
	private long highestNumberToCheck;

	public MultiTaskPrimeNumberCollector(int numberOfTasks, int numberOfThreads, long highestNumberToCheck) {
		this.numberOfTasks = numberOfTasks;
		this.numberOfThreads = numberOfThreads;
		this.highestNumberToCheck = highestNumberToCheck;
	}

	public Set<Long> collectPrimeNumbers() throws InterruptedException, ExecutionException {
		Set<Long> primeNumbers = Collections.synchronizedSet(new HashSet<>());
		ExecutorService executor = Executors.newFixedThreadPool(numberOfThreads);
		List<Future<Set<Long>>> listOfFutures = new ArrayList<>();
		long interval = (long) Math.ceil((double) highestNumberToCheck / numberOfTasks);
		for (int i = 0; i < numberOfTasks; i++) {
			long beginningNumberOfInterval = Math.max(2, i * interval);
			long endNumberOfInterval = Math.min(highestNumberToCheck, (i + 1) * interval);
			Future<Set<Long>> future = executor
					.submit(new PrimeNumberCollectorTask(beginningNumberOfInterval, endNumberOfInterval));
			listOfFutures.add(future);
		}
		getResultsOfTasks(primeNumbers, listOfFutures);
		executor.shutdown();
		return primeNumbers;
	}

	private void getResultsOfTasks(Set<Long> primeNumbers, List<Future<Set<Long>>> listOfFutures)
			throws InterruptedException, ExecutionException {
		for (int i = 0; i < listOfFutures.size(); i++) {
			primeNumbers.addAll(listOfFutures.get(i).get());
		}
	}

}