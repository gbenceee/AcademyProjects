package hu.ak_akademia.asyncfilecopy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CopyFilesTask implements Runnable {
	private List<File> filesToCopy;
	private String pathToCopyTo;

	public CopyFilesTask(List<File> filesToCopy, String pathToCopyTo) {
		this.filesToCopy = filesToCopy;
		this.pathToCopyTo = pathToCopyTo;
	}

	@Override
	public void run() {
		System.out.println("A fájlok másolása megkezdődött.");
		outerLoop: for (File fileToCopy : filesToCopy) {
			System.out.printf("Fájl másolása (%s) megkezdve.%n", fileToCopy.getName());
			String copiedFileName = pathToCopyTo + File.separator + fileToCopy.getName();
			try (BufferedReader in = new BufferedReader(new FileReader(fileToCopy)); PrintWriter out = new PrintWriter(copiedFileName)) {
				String line;
				while ((line = in.readLine()) != null) {
					out.println(line);
					out.flush();
					if (Thread.interrupted()) {
						System.out.println("Fájl másolás megszakítva.");
						out.close();
						File file = new File(copiedFileName);
						System.out.println(file.delete());
						break outerLoop;
					}
				}
			} catch (IOException e) {
				System.out.println("A fájl másolása sikertelen.");
			}
			System.out.printf("Fájl másolása (%s) befejezve.%n", fileToCopy.getName());
		}
		System.out.println("A fájlok másolása befejeződött.");
	}

}
