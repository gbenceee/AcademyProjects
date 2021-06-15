package hu.ak_akademia.obfuscator;

import java.util.Scanner;

public class UserInputHandler {
	private Scanner scan;

	public UserInputHandler(Scanner scan) {
		this.scan = scan;
	}

	public String get() {
		return scan.nextLine();
	}
}
