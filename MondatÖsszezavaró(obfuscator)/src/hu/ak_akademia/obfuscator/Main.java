package hu.ak_akademia.obfuscator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Kérem, adjon meg egy szöveget.");
		String textFromUser = new UserInputHandler(scan).get();
		scan.close();
		List<String> textFromUserInArray = Arrays.asList(textFromUser.split("(?<=[A-Za-zÀ-ɏ])(?=[A-Za-zÀ-ɏ])"));
		new TextObfuscator().iterateThroughTextFromUser(textFromUserInArray);
		System.out.println("Az eredeti mondat: ");
		System.out.println(textFromUser);
		System.out.println("Az összezavart mondat: ");
		new ObfuscatedTextPrinter().print(textFromUserInArray);
	}

}
