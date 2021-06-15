package hu.ak_akademia.prímszámokkiszámítása;

import java.time.Duration;
import java.time.Instant;
import java.util.Set;

public class PrimeNumbersOnSpecifiedNumberOfThreads {

	public static void main(String[] args) throws InterruptedException {
		Instant start = Instant.now();
		Set<Long> primeNumbers = new MultiThreadPrimeNumberCollector(8)
				.collectPrimeNumbersLesserThanSpecifiedNumber(6_000_000L);
		Instant end = Instant.now();
		System.out.println(Duration.between(start, end));
	}

}