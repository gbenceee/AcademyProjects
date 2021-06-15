import java.util.Scanner;

public class EratoszthenészSzitájánakMegvalósítása {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int number;
		while (true) {
			do {
				number = scanNumberFromUser("Kérlek, adj meg egy pozitív egész számot: ");
				if (isUserInputInvalid(number)) {
					System.out.println("A megadott szám nem felel meg a kritériumnak.");
				}
			} while (isUserInputInvalid(number));
			if (number == 1) {
				System.out.println("Eratoszthenész szitája nem határozott meg prím számot.");
			} else {
				int[] numbers = storeNumbers(number);
				int[] primeNumbers = storePrimeNumbers(numbers);
				int counter = countPrimeNumbersInPrimeNumbersArray(primeNumbers);
				System.out.println("Eratoszthenész szitája " + counter + " darab prím számot határozott meg.");
				printPrimeNumbers(primeNumbers);
			}
			System.out.println("Szeretnéd újra futtatni a programot?");
			System.out.println("Ha 0-át adsz meg a program leáll.");
			System.out.println("Ha 1-et adsz meg a program újra lefut.");
			do {
				number = scanNumberFromUser("");
				if (isInputInvalid(number)) {
					System.out.println("Nem elérhető menüpont. Kérlek, adj meg egy érvényes menüpontot.");
				}
			} while (isInputInvalid(number));
			if (number == 0) {
				break;
			}
		}
		System.out.println("Köszönöm, hogy használtad a programot.");
		System.out.println("Viszlát!.");
	}

	static boolean isInputInvalid(int number) {
		return number < 0 || number > 1;
	}

	static void printPrimeNumbers(int[] primeNumbers) {
		for (int i = 0; i < primeNumbers.length; i++) {
			if (primeNumbers[i] > 0) {
				System.out.println(primeNumbers[i]);
			}
		}
	}

	static int scanNumberFromUser(String message) {
		System.out.println(message);
		int number = scan.nextInt();
		scan.nextLine();
		return number;
	}

	static boolean isUserInputInvalid(int number) {
		return number < 1;
	}

	static int[] storeNumbers(int number) {
		int[] numbers = new int[number];
		int currentIndex = 0;
		for (int i = 2; i <= number; i++) {
			numbers[currentIndex] = i;
			currentIndex++;
		}
		return numbers;
	}

	static int[] storePrimeNumbers(int[] numbers) {
		int[] primeNumbers = numbers;
		int currentIndex = 0;
		for (int i = 0; i < primeNumbers.length; i++) {
			if (primeNumbers[i] > 0) {
				for (int j = i + 1; j < primeNumbers.length; j++) {
					if (primeNumbers[j] > 0 && primeNumbers[j] % primeNumbers[i] == 0) {
						primeNumbers[j] = 0;
					}
				}
			}
		}
		return primeNumbers;
	}

	static int countPrimeNumbersInPrimeNumbersArray(int[] primeNumbers) {
		int counter = 0;
		for (int i = 0; i < primeNumbers.length; i++) {
			if (primeNumbers[i] > 0) {
				counter++;
			}
		}
		return counter;
	}

}
