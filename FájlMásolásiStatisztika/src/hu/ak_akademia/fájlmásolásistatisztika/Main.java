package hu.ak_akademia.fájlmásolásistatisztika;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File originalFile = new File("originalfile.pdf");
		File copyOfOriginalFile = new File("copyoforiginalfile.pdf");
		byte[] bufferSize = new byte[100];
		Map<Integer, Long> copyStatistics = new HashMap<>();
		try (FileOutputStream createFile = new FileOutputStream(originalFile);
				FileInputStream readCreatedFile = new FileInputStream(originalFile);
				FileOutputStream copyCreatedFile = new FileOutputStream(copyOfOriginalFile)) {
			System.out.println("Fájl készítés elkezdve...");
			new FileCreator(createFile, originalFile).createFileWithSpecifiedSize(bufferSize, 100 * 1000 * 1000);
			System.out.println("Fájl elkészítve.");
			System.out.println("Másolás elkezdve...");
			new FileCopyStatisticCreator(readCreatedFile, copyCreatedFile).createStatistic(copyStatistics, bufferSize);
			System.out.println("Másolás befejezve.");
		}
		new CopyStatisticPrinter(copyStatistics).printCopyStatisticInAscendingOrderByValue();
	}

}
