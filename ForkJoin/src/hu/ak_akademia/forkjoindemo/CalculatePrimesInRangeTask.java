package hu.ak_akademia.forkjoindemo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CalculatePrimesInRangeTask extends RecursiveTask<Set<Long>> {
	private static final long serialVersionUID = 1L;

	private final long lowerBoundInclusive;
	private final long upperBoundExclusive;

	public CalculatePrimesInRangeTask(long lowerBoundInclusive, long upperBoundExclusive) {
		this.lowerBoundInclusive = lowerBoundInclusive;
		this.upperBoundExclusive = upperBoundExclusive;
	}

	@Override
	protected Set<Long> compute() {
		if (isTaskSmall()) {
			return calculatePrimes();
		} else {
			long middle = (lowerBoundInclusive + upperBoundExclusive) / 2;
			CalculatePrimesInRangeTask task1 = new CalculatePrimesInRangeTask(lowerBoundInclusive, middle);
			CalculatePrimesInRangeTask task2 = new CalculatePrimesInRangeTask(middle, upperBoundExclusive);
			System.out.printf("Túl nagy feladat [%,d - %,d] felosztása két részre: [%,d - %,d], [%,d - %,d]%n", lowerBoundInclusive, upperBoundExclusive, lowerBoundInclusive, middle, middle,
					upperBoundExclusive);
			ForkJoinTask.invokeAll(List.of(task1, task2));
			Set<Long> primes = new HashSet<>();
			try {
				primes.addAll(task1.get());
				primes.addAll(task2.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			return primes;
		}
	}

	private boolean isTaskSmall() {
		return upperBoundExclusive - lowerBoundInclusive < 1_000_000L;
	}

	private Set<Long> calculatePrimes() {
		Set<Long> primes = new HashSet<>();
		for (long probablePrime = lowerBoundInclusive; probablePrime < upperBoundExclusive; probablePrime++) {
			if (isPrime(probablePrime)) {
				primes.add(probablePrime);
			}
		}
		return primes;
	}

	private boolean isPrime(long probablePrime) {
		if (probablePrime < 2) {
			return false;
		}
		if (probablePrime == 2) {
			return true;
		}
		if (probablePrime % 2 == 0) {
			return false;
		}
		long root = (long) Math.ceil(Math.sqrt(probablePrime));
		for (long probableDivisor = 3; probableDivisor <= root; probableDivisor += 2) {
			if (probablePrime % probableDivisor == 0) {
				return false;
			}
		}
		return true;
	}
}
