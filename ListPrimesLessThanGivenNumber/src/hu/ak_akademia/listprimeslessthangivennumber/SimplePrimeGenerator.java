package hu.ak_akademia.listprimeslessthangivennumber;

public class SimplePrimeGenerator implements PrimeGenerator {

	@Override
	public long[] generate(long max) {
		int length = 0;
		for (int i = 2; i < max; i++) {
			if (isPrime(i)) {
				length++;
			}
		}
		long[] primeNumbers = new long[length];
		int index = 0;
		for (int number = 2; number < max; number++) {
			if (isPrime(number)) {
				primeNumbers[index++] = number;
			}
		}
		return primeNumbers;
	}

}
