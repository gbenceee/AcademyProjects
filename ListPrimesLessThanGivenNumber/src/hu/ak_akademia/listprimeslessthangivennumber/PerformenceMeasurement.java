package hu.ak_akademia.listprimeslessthangivennumber;

public class PerformenceMeasurement {

	public static void main(String[] args) {
		int number = 100_000;
		long startTime = System.nanoTime();
		new SimplePrimeGenerator().generate(number);
		long endTime = System.nanoTime();
		System.out.println("Sima: " + (endTime - startTime) / 1_000_000 + " ms");

		startTime = System.nanoTime();
		new SquareRootPrimeGenerator().generate(number);
		endTime = System.nanoTime();
		System.out.println("Gyökös: " + (endTime - startTime) / 1_000_000 + " ms");

		startTime = System.nanoTime();
		new SieveOfEratosthenesPrimeGenerator().generate(number);
		endTime = System.nanoTime();
		System.out.println("Szitás: " + (endTime - startTime) / 1_000_000 + " ms");
	}

}
