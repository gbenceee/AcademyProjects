package hu.ak_akademia.prímszámokkiszámítása;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MultiThreadPrimeNumberCollector {
	private int numberOfThreads;

	public MultiThreadPrimeNumberCollector(int numberOfThreads) {
		this.numberOfThreads = numberOfThreads;
	}

	public Set<Long> collectPrimeNumbersLesserThanSpecifiedNumber(long highestNumberToCheck)
			throws InterruptedException {
		Set<Long> primeNumbers = Collections.synchronizedSet(new HashSet<>());
		List<Thread> threads = new ArrayList<>();
		long interval = (long) Math.ceil((double) highestNumberToCheck / numberOfThreads);
		for (int i = 0; i < numberOfThreads; i++) {
			long beginningNumberOfInterval = Math.max(2, i * interval);
			long endNumberOfInterval = Math.min(highestNumberToCheck, (i + 1) * interval);
			threads.add(new Thread(
					new PrimeNumberCollectorTask(primeNumbers, beginningNumberOfInterval, endNumberOfInterval)));
			threads.get(i).start();
		}
		waitForThreadsToDie(threads);
		return primeNumbers;
	}

	private void waitForThreadsToDie(List<Thread> threads) throws InterruptedException {
		for (int i = 0; i < threads.size(); i++) {
			threads.get(i).join();
		}
	}
}