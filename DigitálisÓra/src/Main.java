import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		DigitalClock test = new DigitalClock(getInputFromUser("Kérem, adja meg az órát.", "Az óra csak 0 és 23 közötti érték lehet.", 23, 0),
				getInputFromUser("Kérem, adja meg a percet.", "A perc csak 0 és 59 közötti érték lehet.", 59, 0),
				getInputFromUser("Kérem, adja meg a másodpercet.", "A másodperc csak 0 és 59 közötti érték lehet.", 59, 0));
		try {
			do {
				System.out.println(test);
				Thread.sleep(1000L);
				test.increaseSecondByOne();
			} while (true);
		} catch (InterruptedException e) {
		}

	}

	static int getInputFromUser(String message, String errorMessage, int highestValue, int lowestValue) {
		int numberFromUser;
		do {
			System.out.println(message);
			numberFromUser = scan.nextInt();
			if (isInputInvalid(numberFromUser, highestValue, lowestValue)) {
				System.out.println(errorMessage);
			}

		} while (isInputInvalid(numberFromUser, highestValue, lowestValue));
		return numberFromUser;
	}

	static boolean isInputInvalid(int numberFromUser, int highestValue, int lowestValue) {
		return numberFromUser > highestValue || numberFromUser < lowestValue;
	}

}
