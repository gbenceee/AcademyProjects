package hu.ak_akademia.listprimeslessthangivennumber;

public class PrimeCalculator {
	private PrimeGenerator generator;
	private PrimePrinter printer;
	private long max;

	public PrimeCalculator(PrimeGenerator generator, PrimePrinter printer, long max) {
		this.generator = generator;
		this.printer = printer;
		this.max = max;
	}

	public void calculate() {
		long[] primes = generator.generate(max);
		printer.printPrimes(primes);

	}
}
