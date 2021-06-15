package hu.ak_akademia.prímszámokkiszámítása;

import java.util.Set;

public class PrimeNumberCollectorTask implements Runnable {
	private Set<Long> primeNumbers;
	private long from;
	private long to;

	public PrimeNumberCollectorTask(Set<Long> primeNumbers, long from, long to) {
		this.primeNumbers = primeNumbers;
		this.from = from;
		this.to = to;
	}

	@Override
	public void run() {
		primeNumbers.addAll(new PrimeNumberCollector().collectPrimeNumbersWithinInterval(from, to));
	}

}