package hu.ak_akademia.szóstatisztikakészítése;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileOutputHandler {

	public void printWordStatisticToFile(List<StringBuilder> listOfWordStatistics, String path) throws IOException {
		try (PrintWriter writeToFile = new PrintWriter(new FileWriter(path))) {
			for (int i = 0; i < listOfWordStatistics.size(); i++) {
				writeToFile.println(listOfWordStatistics.get(i));
			}
		}
	}
}