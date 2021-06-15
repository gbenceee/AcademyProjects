package hu.ak_akademia.producerconsumerdemo;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

public class CreateLargeFileTask implements Runnable {
	private static final int FILE_SIZE_LIMIT_IN_MEGABYTES = 1_000;
	private final List<String> words;
	private final Random random = new Random();

	public CreateLargeFileTask(List<String> words) {
		this.words = words;
	}

	public void run() {
		String fileName = "copyFrom/" + getRandomWord() + ".txt";
		System.out.printf("Fájl létrehozása (%s) megkezdve.%n", fileName);
		long fileSize = 0;
		try (PrintWriter out = new PrintWriter(fileName)) {
			while (fileSize < FILE_SIZE_LIMIT_IN_MEGABYTES * 1_000 * 1_000) {
				String randomWord = getRandomWord();
				out.print(randomWord);
				fileSize += randomWord.length();
				if (random.nextInt(200) == 0) {
					out.println(".");
					fileSize += 2;
				} else {
					out.print(" ");
					fileSize += 1;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.printf("Fájl létrehozása (%s) kész.%n", fileName);
		}
	}

	private String getRandomWord() {
		return null;
	}
}
