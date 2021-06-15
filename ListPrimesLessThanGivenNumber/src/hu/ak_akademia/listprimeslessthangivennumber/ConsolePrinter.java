package hu.ak_akademia.listprimeslessthangivennumber;

public class ConsolePrinter implements PrimePrinter {

	@Override
	public void printPrimes(long[] primes) {
		for (long prime : primes) {
			System.out.println(prime);
		}
	}

}
