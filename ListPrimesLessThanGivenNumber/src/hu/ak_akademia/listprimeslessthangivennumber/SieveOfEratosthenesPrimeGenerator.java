package hu.ak_akademia.listprimeslessthangivennumber;

public class SieveOfEratosthenesPrimeGenerator implements PrimeGenerator {

	@Override
	public long[] generate(long max) {
		if (max < 2) {
			return new long[0];
		}

		boolean[] primes = new boolean[(int) max];

		primes[0] = true;
		primes[1] = true;

		int numberOfPrimes = 0;

		for (int i = 2; i < max; i++) {
			if (!primes[i]) {
				excludeMultiples(primes, i);
				numberOfPrimes++;
			}

		}

		long[] thePrimes = new long[numberOfPrimes];

		int index = 0;
		for (int i = 0; i < max; i++) {
			if (!primes[i]) {
				thePrimes[index++] = i;
			}
		}

		return thePrimes;
	}

	private void excludeMultiples(boolean[] primes, int number) {
		for (int i = 2 * number; i < primes.length; i += number) {
			primes[i] = true;
		}
	}

}
