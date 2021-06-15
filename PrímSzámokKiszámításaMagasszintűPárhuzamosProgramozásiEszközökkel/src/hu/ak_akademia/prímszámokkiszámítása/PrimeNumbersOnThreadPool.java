package hu.ak_akademia.prímszámokkiszámítása;

import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class PrimeNumbersOnThreadPool {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Instant start = Instant.now();
		Set<Long> primeNumbers = new MultiTaskPrimeNumberCollector(10, 2, 2_000_000).collectPrimeNumbers();
		Instant end = Instant.now();
		System.out.println(Duration.between(start, end));
	}

}