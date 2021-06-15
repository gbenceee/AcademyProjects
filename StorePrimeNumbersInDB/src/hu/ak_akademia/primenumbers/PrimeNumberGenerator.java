package hu.ak_akademia.primenumbers;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberGenerator implements NumberGenerator {

	@Override
	public List<Integer> generate(int limit) {
		List<Integer> primes = new ArrayList<>();
		for (int number = 2; number < limit; number++) {
			if (isPrime(number)) {
				primes.add(number);
			}
		}
		return primes;
	}

	private boolean isPrime(int number) {
		if (number < 2) {
			return false;
		}
		if (number == 2) {
			return true;
		}
		int root = (int) (Math.sqrt(number) + 1);
		for (int possibleDivisor = 2; possibleDivisor <= root; possibleDivisor++) {
			if (number % possibleDivisor == 0) {
				return false;
			}
		}
		return true;
	}

}
