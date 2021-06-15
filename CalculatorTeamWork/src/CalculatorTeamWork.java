import java.util.Scanner;

public class CalculatorTeamWork {

	public static void main(String[] args) {

		int menuPoint;
		do {
			printMenu();
			do {
				menuPoint = scanNumberFromUser("Válasszon: ");
				if (isMenuPointNotAvailable(menuPoint)) {
					System.out.println("Érvénytelen menüpont. Kérem adjon meg egy érvényes menüpontot.");
				}
			} while (isMenuPointNotAvailable(menuPoint));
			switch (menuPoint) {
			case 1:
				System.out.println("Összeg: " + executeAddition());
				break;
			case 2:
				System.out.println("Különbség: " + executeSubtraction());
				break;
			case 3:
				System.out.println("Szorzat: " + executeMultiplication());
				break;
			case 4:
				System.out.println("Hányados: " + executeDivision());
				break;
			}
		} while (menuPoint < 5);
		System.out.println("Köszönöm, hogy a számológépet használta!");
	}

	static void printMenu() {
		System.out.println("SZÁMOLÓGÉP");
		System.out.println("----------");
		System.out.println("1 - Összeadás");
		System.out.println("2 - Kivonás");
		System.out.println("3 - Szorzás");
		System.out.println("4 - Osztás");
		System.out.println("5 - Kilépés");
	}

	static int scanNumberFromUser(String message) {
		Scanner in = new Scanner(System.in);
		System.out.println(message);
		int number = in.nextInt();
		in.nextLine();
		return number;
	}

	static boolean isMenuPointNotAvailable(int menuPoint) {
		return menuPoint < 1 || menuPoint > 5;
	}

	static int executeAddition() {
		System.out.println("Összeadás");
		int firstAddend = scanNumberFromUser("Kérem, adja meg az első tagot: ");
		int secondAddend = scanNumberFromUser("Kérem, adja meg a második tagot: ");
		int sum = firstAddend + secondAddend;
		return sum;
	}

	static int executeSubtraction() {
		System.out.println("Kivonás");
		int minuend = scanNumberFromUser("Kérem, adja meg a kisebbítendőt: ");
		int subtrahend = scanNumberFromUser("Kérem, adja meg a kivonandót: ");
		int difference = minuend - subtrahend;
		return difference;
	}

	static int executeMultiplication() {
		System.out.println("Szorzás");
		int multiplicand = scanNumberFromUser("Kérem, adja meg a szorzandót: ");
		int multiplier = scanNumberFromUser("Kérem, adja meg a szorzót: ");
		int product = multiplicand * multiplier;
		return product;
	}

	static int executeDivision() {
		System.out.println("Osztás");
		int dividend = scanNumberFromUser("Kérem, adja meg az osztandót: ");
		int divisor;
		do {
			divisor = scanNumberFromUser("Kérem, adja meg az osztót: ");
			if (divisor == 0) {
				System.out.println("Nullával nem lehet osztani!");
			}
		} while (divisor == 0);
		int quotient = dividend / divisor;
		return quotient;
	}

}
