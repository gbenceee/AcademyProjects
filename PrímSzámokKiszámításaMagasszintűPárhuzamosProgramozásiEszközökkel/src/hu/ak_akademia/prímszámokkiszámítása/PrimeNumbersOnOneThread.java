package hu.ak_akademia.prímszámokkiszámítása;

import java.time.Duration;
import java.time.Instant;
import java.util.Set;

public class PrimeNumbersOnOneThread {

	public static void main(String[] args) throws InterruptedException {
		Instant start = Instant.now();
		Set<Long> primeNumbers = new PrimeNumberCollector().collectPrimeNumbersLesserThanSpecifiedNumber(2_000_000);
		Instant end = Instant.now();
		System.out.println(Duration.between(start, end));
	}

}