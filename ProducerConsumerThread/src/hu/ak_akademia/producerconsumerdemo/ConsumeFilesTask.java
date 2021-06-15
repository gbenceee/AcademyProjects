package hu.ak_akademia.producerconsumerdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ConsumeFilesTask implements Runnable {
	private final FilesToMove filesToMove;
	private final String pathToCopyTo;

	public ConsumeFilesTask(FilesToMove filesToMove, String pathToCopyTo) {
		this.filesToMove = filesToMove;
		this.pathToCopyTo = pathToCopyTo;
	}

	@Override
	public void run() {
		for (String sourceFileName = filesToMove.take(); !"DONE".equals(sourceFileName); sourceFileName = filesToMove.take()) {
			File sourceFile = new File(sourceFileName);
			String destinationFileName = pathToCopyTo + File.separator + sourceFile.getName();
			File destinationFile = new File(destinationFileName);
			System.out.printf("A fájl (%s) (%d MB) másolása megkezdődött.%n", sourceFile.getName(), sourceFile.length() / 1_000 / 1_000);
			try (BufferedReader in = new BufferedReader(new FileReader(sourceFile)); PrintWriter out = new PrintWriter(destinationFile)) {
				String line;
				while ((line = in.readLine()) != null) {
					out.println(line);
					out.flush();
				}
			} catch (IOException e) {
				System.out.printf("A fájl (%s) másolása sikertelen.", sourceFileName);
			}
			System.out.printf("Fájl másolása (%s) befejezve.%n", sourceFileName);
			sourceFile.delete();
		}
		System.out.println("Consumer kész.");

	}

}
