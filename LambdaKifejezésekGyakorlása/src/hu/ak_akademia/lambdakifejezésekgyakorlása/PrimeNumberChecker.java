package hu.ak_akademia.lambdakifejezésekgyakorlása;

import java.util.stream.IntStream;

public class PrimeNumberChecker {
	public boolean isPrime(int numberToDecide) {
		if (numberToDecide < 2) {
			return false;
		} else {
			return !IntStream.range(2, numberToDecide).filter(number -> numberToDecide % number == 0).findFirst()
					.isPresent();
		}

	}
}
