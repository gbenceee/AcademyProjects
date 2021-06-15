package hu.ak_akademia.szóstatisztikakészítése;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileInputHandler {

	public List<String> readAndStoreDataFromFileInput(String path) throws FileNotFoundException, IOException {
		List<String> listOfDataFromFileInput = new ArrayList<>();
		try (BufferedReader readFromFile = new BufferedReader(new FileReader(path))) {
			while (readFromFile.ready()) {
				listOfDataFromFileInput.add(readFromFile.readLine());
			}
		}
		return listOfDataFromFileInput;
	}
}