import java.util.Scanner;

public class PrimeNumberChecker {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Kérem, adjon meg egy pozitív egész számot: ");
		int numberToCheck = scanner.nextInt();
		scanner.nextLine();
		boolean prime = true;
		if (numberToCheck < 2) {
			prime = false;
		}
		for (int divisor = 2; divisor < numberToCheck; divisor++) {
			if (numberToCheck % divisor == 0) {
				prime = false;
				break;
			}
		}
		System.out.println("A megadott szám " + (prime ? "prím" : "összetett") + ".");
	}

}