package hu.ak_akademia.task2;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class UserInputHandler {
	private Scanner scan;

	public UserInputHandler(Scanner scan) {
		this.scan = scan;
	}

	public Set<Integer> getCorrectLotteryNumbers() {
		Set<Integer> set = new TreeSet<>();
		int number = 0;
		do {
			System.out.println("Kérem, adjon meg egy egész számot 1 és 90 között.");
			try {
				number = scan.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Csak egész számot adhat meg.");
				scan.nextLine();
				continue;
			}
			printIncorrectInputMessageIfNecessary(set, number);
		} while (set.size() < 5 || number < 1 || number > 90);
		return set;
	}

	private void printIncorrectInputMessageIfNecessary(Set<Integer> set, int number) {
		if (number < 1 || number > 90) {
			System.out.println("A megadott szám nem megfelelő.");
		} else if (!set.add(number)) {
			System.out.println("Egy számot csak egyszer lehet megadni.");
		} else {
			set.add(number);
		}
	}
}
