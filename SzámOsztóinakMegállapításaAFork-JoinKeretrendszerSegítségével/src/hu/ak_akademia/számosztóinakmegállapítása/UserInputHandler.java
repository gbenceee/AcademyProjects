package hu.ak_akademia.számosztóinakmegállapítása;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputHandler {
	private Scanner scan;

	public UserInputHandler(Scanner scan) {
		this.scan = scan;
	}

	public long scanCorrectNumberFromUser() {
		long numberFromUser = 0;
		do {
			try {
				System.out.println("Kérem, adjon meg egy pozitív egész számot!");
				numberFromUser = scan.nextLong();
				if (isNumberIncorrect(numberFromUser)) {
					System.out.println("A megadott szám nem pozitív.");
				}
			} catch (InputMismatchException e) {
				System.out.println("A program csak pozitív egész számot fogad el.");
				scan.nextLine();
			}
		} while (isNumberIncorrect(numberFromUser));
		return numberFromUser;
	}

	private boolean isNumberIncorrect(long number) {
		return number < 1;
	}

}