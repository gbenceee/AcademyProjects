package hu.ak_akademia.listprimeslessthangivennumber;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			UserInputManager input = new UserInputManager(scanner);
			long userGivenNumber = input.getLongFromUser();
			new PrimeCalculator(new SimplePrimeGenerator(), new ConsolePrinter(), userGivenNumber).calculate();
			new PrimeCalculator(new SquareRootPrimeGenerator(), new ConsolePrinter(), userGivenNumber).calculate();
			new PrimeCalculator(new SieveOfEratosthenesPrimeGenerator(), new ConsolePrinter(), userGivenNumber).calculate();
			new PrimeCalculator(new SimplePrimeGenerator(), new FilePrinter("sima"), userGivenNumber).calculate();
			new PrimeCalculator(new SquareRootPrimeGenerator(), new FilePrinter("gyökös"), userGivenNumber).calculate();
			new PrimeCalculator(new SieveOfEratosthenesPrimeGenerator(), new FilePrinter("szita"), userGivenNumber).calculate();
		}
	}

}
