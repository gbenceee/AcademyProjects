import java.util.Scanner;

public class MásodfokúEgyenletMegoldása {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		double coefficientA = scanNumberFromUser("Kérem, adja meg az 'a' együtthatót");
		double coefficientB = scanNumberFromUser("Kérem, adja meg az 'b' együtthatót");
		double coefficientC = scanNumberFromUser("Kérem, adja meg az 'c' együtthatót");
		double resultOfx1 = (-1 * coefficientB
				+ Math.sqrt((coefficientB * coefficientB) - (4 * coefficientA * coefficientC))) / (2 * coefficientA);
		double resultOfx2 = (-1 * coefficientB
				- Math.sqrt((coefficientB * coefficientB) - (4 * coefficientA * coefficientC))) / (2 * coefficientA);
		double discriminant = (coefficientB * coefficientB) - (4 * coefficientA * coefficientC);
		if (discriminant > 0) {
			System.out.println("A másodfokú egyenletnek 2 valós gyöke van.");
			System.out.println("x1 = " + resultOfx1);
			System.out.println("x2 = " + resultOfx2);
		}
		if (discriminant == 0) {
			System.out.println("A másodfokú egyenletnek 1 valós gyöke van.");
			System.out.println("x1 és x2 = " + resultOfx1);
		}
		if (discriminant < 0) {
			System.out.println("A másodfokú egyenletnek nincs valós gyöke.");
		}
	}

	static int scanNumberFromUser(String message) {
		System.out.println(message);
		int number = scan.nextInt();
		return number;
	}

}
