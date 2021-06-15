package hu.ak_akademia.felhasználóiadatbevitelvalidálással;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetInputFromUser {
	private Scanner scan;

	public GetInputFromUser(Scanner scan) {
		this.scan = scan;
	}

	public int getIntegerFromUser(String message) {
		int number;
		loop: while (true) {
			System.out.println(message);
			try {
				number = scan.nextInt();
				break loop;
			} catch (InputMismatchException e) {
				System.out.println("Csak egész számot adhat meg.");
				scan.nextLine();
			}
		}
		return number;
	}

	public double getDoubleFromUser(String message) {
		double number;
		loop: while (true) {
			System.out.println(message);
			try {
				number = scan.nextDouble();
				break loop;
			} catch (InputMismatchException e) {
				System.out.println("Csak számot adhat meg.");
				scan.nextLine();
			}
		}
		return number;
	}

	public String getStringFromUser(String message) {
		System.out.println(message);
		String text = scan.nextLine();
		return text;
	}

	public String getLogicalValueFromUser(String message) {
		return getStringFromUser(message);
	}
}
