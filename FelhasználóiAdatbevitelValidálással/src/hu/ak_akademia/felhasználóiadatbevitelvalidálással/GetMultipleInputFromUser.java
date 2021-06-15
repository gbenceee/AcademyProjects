package hu.ak_akademia.felhasználóiadatbevitelvalidálással;

import java.util.Scanner;

public class GetMultipleInputFromUser {
	private Scanner scan;

	public GetMultipleInputFromUser(Scanner scan) {
		this.scan = scan;
	}

	public int[] getMultipleIntegerInputFromUser(String message) {
		GetInputFromUser get = new GetInputFromUser(scan);
		int number;
		do {
			number = get.getIntegerFromUser("Kérem, adja meg, hogy hány egész számot szeretne megadni.");
			if (number < 1) {
				System.out.println("A megadott szám kisebb mint egy.");
			}
		} while (number < 1);
		int[] multipleInteger = new int[number];
		for (int i = 0; i < multipleInteger.length; i++) {
			multipleInteger[i] = get.getIntegerFromUser(message);
		}
		return multipleInteger;
	}

	public double[] getMultipleDoubleInputFromUser(String message) {
		GetInputFromUser get = new GetInputFromUser(scan);
		int sizeOfArray;
		do {
			sizeOfArray = get.getIntegerFromUser("Kérem, adja meg, hogy hány számot szeretne megadni.");
			if (sizeOfArray < 1) {
				System.out.println("A megadott szám kisebb mint egy.");
			}
		} while (sizeOfArray < 1);
		double[] multipleInteger = new double[sizeOfArray];
		for (int i = 0; i < multipleInteger.length; i++) {
			multipleInteger[i] = get.getDoubleFromUser(message);
		}
		return multipleInteger;
	}

	public String[] getMultipleStringInputFromUser(String message) {
		GetInputFromUser get = new GetInputFromUser(scan);
		int sizeOfArray;
		do {
			sizeOfArray = get.getIntegerFromUser("Kérem, adja meg, hogy hányszor szeretne szöveget bevinni.");
			if (sizeOfArray < 1) {
				System.out.println("A megadott szám kisebb mint egy.");
			}
		} while (sizeOfArray < 1);
		scan.nextLine();
		String[] multipleStringInputFromUser = new String[sizeOfArray];
		for (int i = 0; i < multipleStringInputFromUser.length; i++) {
			multipleStringInputFromUser[i] = get.getStringFromUser(message);
		}
		return multipleStringInputFromUser;
	}
}
