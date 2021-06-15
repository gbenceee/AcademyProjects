package hu.ak_akademia.listprimeslessthangivennumber;

public interface PrimeGenerator {
	long[] generate(long max);

	default boolean isPrime(long number) {
		if (number < 2) {
			return false;
		}
		long divisor = 2;
		while (divisor < number) {
			if (number % divisor == 0) {
				return false;
			}
			divisor++;
		}
		return true;
	}
}
