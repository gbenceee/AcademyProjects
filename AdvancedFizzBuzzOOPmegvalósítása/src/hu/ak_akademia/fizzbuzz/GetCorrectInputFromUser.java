package hu.ak_akademia.fizzbuzz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetCorrectInputFromUser implements Readable {
	public Scanner scan;

	public GetCorrectInputFromUser(Scanner scan) {
		this.scan = scan;
	}

	@Override
	public int getInput() {
		int number = 0;
		do {
			System.out.println("Kérem, adjon meg egy egész számot 10 és 100 között.");
			try {
				number = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Csak egész számot adhat meg.");
				scan.nextLine();
				continue;
			}
			if (number < 10 || number > 100) {
				System.out.println("A megadott szám nem megfelelő.");
			}
		} while (number < 10 || number > 100);
		return number;
	}

}
