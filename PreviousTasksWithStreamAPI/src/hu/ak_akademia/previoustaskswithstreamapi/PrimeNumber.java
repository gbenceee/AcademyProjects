package hu.ak_akademia.previoustaskswithstreamapi;

import java.util.stream.IntStream;

public class PrimeNumber {

	public static void main(String[] args) {
		// hagyományos imperatív megközelítés
		for (int i = 0; i < 100; i++) {
			if (isPrimeOldFashioned(i)) {
				System.out.println(i);
			}
		}

		System.out.println("----------");

		// fél-funkcionális megközelítés
		IntStream.rangeClosed(0, 100)
				.filter(PrimeNumber::isPrimeOldFashioned)
//              .filter(number -> isPrime(number))
				.forEach(System.out::println);

		System.out.println("----------");

		// teljesen funkcionális megközelítés
		System.out.println(isPrime(75));
		System.out.println(isPrime(73));
	}

	static boolean isPrime(int numberToDecideIfPrime) {
		return IntStream.range(2, numberToDecideIfPrime)
				.filter(number -> numberToDecideIfPrime % number == 0)
				.findFirst()
				.isEmpty();
	}

	static boolean isPrimeOldFashioned(int number) {
		if (number < 2) {
			return false;
		}
		for (int possibleDivisor = 2; possibleDivisor < number; possibleDivisor++) {
			if (number % possibleDivisor == 0) {
				return false;
			}
		}
		return true;
	}
}
