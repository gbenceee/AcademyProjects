package hu.ak_akademia.prímszámokkiszámítása;

import java.util.Set;
import java.util.concurrent.Callable;

public class PrimeNumberCollectorTask implements Callable<Set<Long>> {
	private long beginningNumberOfInterval;
	private long endNumberOfInterval;

	public PrimeNumberCollectorTask(long beginningNumberOfInterval, long endNumberOfInterval) {
		this.beginningNumberOfInterval = beginningNumberOfInterval;
		this.endNumberOfInterval = endNumberOfInterval;
	}

	@Override
	public Set<Long> call() throws Exception {
		return new PrimeNumberCollector().collectPrimeNumbersWithinInterval(beginningNumberOfInterval,
				endNumberOfInterval);
	}

}