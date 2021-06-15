package hu.ak_akademia.listprimeslessthangivennumber;

import java.util.Scanner;

public class UserInputManager {
	private Scanner scan;

	public UserInputManager(Scanner scan) {
		this.scan = scan;
	}

	long getLongFromUser() {
		System.out.println("Kérem adjon meg egy számot: ");
		long number = scan.nextLong();
		scan.nextLine();
		return number;
	}
}
