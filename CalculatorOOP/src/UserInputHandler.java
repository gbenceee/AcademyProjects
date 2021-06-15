import java.util.Scanner;

public class UserInputHandler {
	private Scanner scan;

	public UserInputHandler(Scanner scan) {
		this.scan = scan;
	}

	public int getInteger(String message) {
		System.out.println(message);
		int number = scan.nextInt();
		scan.nextLine();
		return number;
	}

	public int getInteger(String message, int min, int max) {
		int number;
		do {
			number = getInteger(message);
			if (isNumberOutOfBounds(min, max, number)) {
				System.out.println("A megadott szám tartományon kívül esik.(" + min + "-" + max + ")");
			}
		} while (isNumberOutOfBounds(min, max, number));
		return number;
	}

	private boolean isNumberOutOfBounds(int min, int max, int number) {
		return number > max || number < min;
	}

	public double getDouble(String message) {
		System.out.println(message);
		double number = scan.nextDouble();
		scan.nextLine();
		return number;
	}
}
