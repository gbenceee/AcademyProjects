import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		new Main().run();
	}

	static void run() {
		Scanner scan = new Scanner(System.in);
		Coordinate object = createObject(scan);
		System.out.println(object);
		scan.close();
	}

	static String getValidStringInputFromUser(Scanner scan, String message, String condition) {
		String numberAsString;
		do {
			System.out.println(message);
			numberAsString = scan.nextLine();
			if (!Pattern.matches(condition, numberAsString)) {
				System.out.println("A megadott szám helytelen.");
			}

		} while (!Pattern.matches(condition, numberAsString));
		return numberAsString;
	}

	static int convertStringInputFromUserToInteger(String numberAsString) {
		numberAsString = numberAsString.replaceAll(" ", "");
		return Integer.parseInt(numberAsString);
	}

	static Coordinate createObject(Scanner scan) {
		String firstNumberAsString = getValidStringInputFromUser(scan, "Kérem, adjon meg egy legalább 1 és legfeljebb 8 számjegyű számot.", "^[ ]*?[+-]?\\d{1,8}[ ]*?$");
		String secondNumberAsString = getValidStringInputFromUser(scan, "Kérem, adjon meg egy másik legalább 1 és legfeljebb 8 számjegyű számot.", "^[ ]*?[+-]?\\d{1,8}[ ]*?$");
		int firstNumber = convertStringInputFromUserToInteger(firstNumberAsString);
		int secondNumber = convertStringInputFromUserToInteger(secondNumberAsString);
		Coordinate test = new Coordinate(firstNumber, secondNumber);
		return test;
	}

}
