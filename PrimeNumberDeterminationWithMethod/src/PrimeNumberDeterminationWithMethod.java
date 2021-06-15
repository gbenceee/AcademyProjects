import java.util.Scanner;

public class PrimeNumberDeterminationWithMethod {

	public static void main(String[] args) {
		System.out.print("Kérem, adjon meg egy egész számot: ");
		int number = scan();
		if (isPrime(number)) {
			System.out.println("Prímszám.");
		} else {
			System.out.println("Összetett szám.");
		}
	}

	static boolean isPrime(int number) {
		if (number < 2) {
			return false;
		}
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	static int scan() {
		Scanner scanner = new Scanner(System.in);
		int scannedNumber = scanner.nextInt();
		scanner.nextLine();
		return scannedNumber;
	}

}