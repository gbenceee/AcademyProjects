package hu.ak_akademia.forkjoindemo;

import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinDemo {
	private static final long N = 10_000_000L;

	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
		CalculatePrimesInRangeTask task = new CalculatePrimesInRangeTask(0, N);
		Instant start = Instant.now();
		Set<Long> primes = forkJoinPool.invoke(task);
		Instant end = Instant.now();
		System.out.printf("A számolás %,d ms-ig tartott.%n", Duration.between(start, end)
				.toMillis());
//	      primes.stream().forEach(System.out::println);
		System.out.printf("Talált prímek száma: %,d db%n", primes.size());
	}

}
