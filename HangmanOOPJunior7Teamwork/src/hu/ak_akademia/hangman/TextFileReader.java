package hu.ak_akademia.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextFileReader {

	public String[] readWords(String fileNameToLoad) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(fileNameToLoad));
		int countLines = countLines(fileNameToLoad);

		String[] words = new String[countLines];

		for (int i = 0; i < countLines; i++) {
			words[i] = scanner.nextLine();
		}
		scanner.close();

		return words;
	}

	private int countLines(String fileNameToLoad) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(fileNameToLoad));
		int numberOfLines = 0;
		while (scanner.hasNextLine()) {
			numberOfLines++;
			scanner.nextLine();
		}
		scanner.close();
		return numberOfLines;
	}
}
