package hu.ak_akademia.listprimeslessthangivennumber;

public class SquareRootPrimeGenerator implements PrimeGenerator {

	@Override
	public long[] generate(long max) {
		long[] primeNumbers = new long[max / 2 + 1 > Integer.MAX_VALUE ? Integer.MAX_VALUE - 10 : (int) (max / 2 + 1)];

		int index = 0;
		for (int i = 2; i < max; i++) {
			if (isPrime(i)) {
				primeNumbers[index++] = i;
			}
		}
		long[] finalPrimeNumbers = new long[index];
		System.arraycopy(primeNumbers, 0, finalPrimeNumbers, 0, index);
		return finalPrimeNumbers;
	}

	@Override
	public boolean isPrime(long number) {
		if (number < 2) {
			return false;
		}
		if (number == 2) {
			return true;
		}
		long divisor = 2;
		int limit = (int) (Math.sqrt(number) + 2);
		while (divisor < limit) {
			if (number % divisor == 0) {
				return false;
			}
			divisor++;
		}
		return true;
	}

}
