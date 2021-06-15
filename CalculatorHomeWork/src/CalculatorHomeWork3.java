import java.util.Scanner;

public class CalculatorHomeWork3 {

	public static void main(String[] args) {
		//math.pow(int a, int b) hatványozás
		//math.sqrt(int a, int b) négyzetgyökvonás
		int chosenMenuPoint;
		do {
			printMenu();
			chosenMenuPoint = scanNumberFromUser("Kérem válasszon menüpontot.");
			if (isMenuPointAvailable(chosenMenuPoint)) {
				do {
					System.out.println("Érvénytelen menüpont.");
					chosenMenuPoint = scanNumberFromUser("Kérem válasszon egy érvényes menüpontot.");
				} while (isMenuPointAvailable(chosenMenuPoint));
			}
			switch (chosenMenuPoint) {
			case 1:
				System.out.println("Az összeg: " + addition());
				break;
			case 2:
				System.out.println("A különbség: " + subtraction());
				break;
			case 3:
				System.out.println("A szorzat: " + multiply());
				break;
			case 4:
				System.out.println("A hányados: " + divide());
				break;
			}
		} while (chosenMenuPoint != 5);
		System.out.println("Köszönjük, hogy a számológépet használta!");
	}

	static void printMenu() {
		System.out.println("SZÁMOLÓGÉP");
		System.out.println("----------");
		System.out.println("1: Összeadás");
		System.out.println("2: Kivonás");
		System.out.println("3: Szorzás");
		System.out.println("4: Osztás");
		System.out.println("5: Kilépés");
	}

	static int scanNumberFromUser(String message) {
		System.out.println(message);
		Scanner scan = new Scanner(System.in);
		int scannedNumber = scan.nextInt();
		scan.nextLine();
		return scannedNumber;
	}

	static boolean isMenuPointAvailable(int MenuPoint) {
		return MenuPoint < 1 || MenuPoint > 5;
	}

	static int addition() {
		System.out.println("Összeadás");
		int firstAddend = scanNumberFromUser("Kérem adja meg az első tagot: ");
		int secondAddend = scanNumberFromUser("Kérem adja meg a második tagot: ");
		int sum = firstAddend + secondAddend;
		return sum;
	}

	static int subtraction() {
		System.out.println("Kivonás");
		int minuend = scanNumberFromUser("Kérem, adja meg a kisebbítendőt: ");
		int subtrahend = scanNumberFromUser("Kérem, adja meg a kivonandót: ");
		int difference = minuend - subtrahend;
		return difference;
	}

	static int multiply() {
		System.out.println("Szorzás");
		int multiplicand = scanNumberFromUser("Kérem adja meg a szorzandót: ");
		int multiplier = scanNumberFromUser("Kérem adja meg a szorzót: ");
		int product = multiplicand * multiplier;
		return product;
	}

	static int divide() {
		System.out.println("Osztás");
		int dividend = scanNumberFromUser("Kérem, adja meg az osztandót: ");
		int divisor;
		do {
			divisor = scanNumberFromUser("Kérem, adja meg az osztót: ");
			if (divisor == 0) {
				System.out.println("Nullával nem lehet osztani.");
			}
		} while (divisor == 0);
		int quotient = dividend / divisor;
		return quotient;
	}

}
