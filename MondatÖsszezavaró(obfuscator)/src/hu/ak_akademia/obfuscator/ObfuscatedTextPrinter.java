package hu.ak_akademia.obfuscator;

import java.util.List;

public class ObfuscatedTextPrinter {
	public void print(List<String> textFromUserInArray) {
		for (int i = 0; i < textFromUserInArray.size(); i++) {
			System.out.print(textFromUserInArray.get(i));
		}
	}
}
