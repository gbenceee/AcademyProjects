package hu.ak_akademia.listprimeslessthangivennumber;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

public class FilePrinter implements PrimePrinter {

	private String fileName;

	public FilePrinter(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void printPrimes(long[] primes) {
		try (PrintWriter printWriter = new PrintWriter("output/" + fileName + ".txt", Charset.forName("UTF-8"))) {
			for (long prime : primes) {
				printWriter.println(prime);
			}
		} catch (IOException e) {
			System.out.println("A fájl írása sikertelen");
		}
	}

}
