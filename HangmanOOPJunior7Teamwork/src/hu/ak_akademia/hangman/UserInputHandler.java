package hu.ak_akademia.hangman;

import java.util.Scanner;

public class UserInputHandler {
	private Scanner scan;

	public UserInputHandler(Scanner scan) {
		this.scan = scan;
	}

	public String getCharacter(String message) {
		String guessedLetter;
		do {
			System.out.println(message);
			guessedLetter = this.scan.nextLine()
					.trim();
			if (guessedLetter.length() != 1) {
				System.out.println("Hibás bevitel csak egy betűt lehet megadni.");
			}
		} while (guessedLetter.length() != 1);
		return guessedLetter;
	}

	public String getWord(String message) {
		System.out.println(message);
		String guessedWord = this.scan.nextLine()
				.trim();
		return guessedWord;
	}
}
