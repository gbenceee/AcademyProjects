import java.util.Scanner;

public class PitagoraszTétel {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		double firstLeg = 0;
		double secondLeg = 0;
		firstLeg = scanLegFromUser(firstLeg, "Kérem, adja meg a derékszögű háromszög egyik befogóját centiméterben:  ");
		secondLeg = scanLegFromUser(secondLeg,
				"Kérem, adja meg a derékszögű háromszög másik befogóját centiméterben:  ");
		double hypotenuse;
		hypotenuse = countHypotenuse(firstLeg, secondLeg);
		System.out.println("A derékszögű háromszög leghosszabb oldala " + hypotenuse + " centiméter hosszú.");
	}

	static double scanNumberFromUser() {
		double number = scan.nextDouble();
		scan.nextLine();
		return number;
	}

	static boolean isLegInvalid(double leg) {
		return leg <= 0;
	}

	static double scanLegFromUser(double leg, String message) {
		do {
			System.out.println(message);
			leg = scanNumberFromUser();
			if (isLegInvalid(leg)) {
				System.out.println("A befogó hossza csak nullánál nagyobb pozitív szám lehet.");
			}
		} while (isLegInvalid(leg));
		return leg;
	}

	static double countHypotenuse(double firstLeg, double secondLeg) {
		double hypotenuse = 0;
		hypotenuse = (firstLeg * firstLeg) + (secondLeg * secondLeg);
		hypotenuse = Math.sqrt(hypotenuse);

		return hypotenuse;
	}
}
