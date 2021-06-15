import java.util.Scanner;

public class HáromSzámÖsszege {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int number;
		do {
			number = scanNumberFromUser("Kérlek, adj meg egy pozitív egész számot!");
			if (isNumberInvalid(number)) {
				System.out.println("Érvénytelen számot adtál meg.");
			}
		} while (isNumberInvalid(number));
		long[] arrayOfSums = fillArrayWithSumOfThreeNumbers(number);
		System.out.println("Három szám összege:");
		printOutSumOfThreeNumbers(number);
		System.out.println();
		System.out.println("Három szám összege szimmetrikusan:");
		printOutSymmetricSumOfThreeNumbers(arrayOfSums, number);
	}

	static boolean isNumberInvalid(int number) {
		return number <= 0;
	}

	static int scanNumberFromUser(String message) {
		System.out.println(message);
		int number = scan.nextInt();
		scan.nextLine();
		return number;
	}

	static void printOutSumOfThreeNumbers(int number) {
		for (int i = 0; i <= number; i++) {
			for (int j = 0; j <= number; j++) {
				for (int k = 0; k <= number; k++) {
					if (i + j + k == number) {
						System.out.println(i + " + " + j + " + " + k + " = " + (i + j + k));
					}
				}
			}
		}
	}

	static void printOutSymmetricSumOfThreeNumbers(long[] arrayOfSums, int number) {
		int currentIndex = 0;
		int currentPlusOneIndex = 1;
		int currentPlusTwoIndex = 2;
		long counter = arrayOfSums[arrayOfSums.length - 1];
		int firstIndex = 0;
		int secondIndex = 1;
		int thirdIndex = 2;
		for (int i = 0; i < counter; i++) {
			currentIndex = firstIndex;
			currentPlusOneIndex = secondIndex;
			currentPlusTwoIndex = thirdIndex;
			boolean firstOccurence = true;
			long a = arrayOfSums[firstIndex];
			long b = arrayOfSums[secondIndex];
			long c = arrayOfSums[thirdIndex];
			for (int j = i; j < counter; j++) {
				if (a + b + c == number) {
					if (firstOccurence) {
						System.out.println(a + " + " + b + " + " + c + " = " + (a + b + c));
						firstOccurence = false;
					} else {
						if ((arrayOfSums[currentIndex] == a && arrayOfSums[currentPlusOneIndex] == c
								&& arrayOfSums[currentPlusTwoIndex] == b)
								|| (arrayOfSums[currentIndex] == a && arrayOfSums[currentPlusOneIndex] == c
										&& arrayOfSums[currentPlusTwoIndex] == b)
								|| (arrayOfSums[currentIndex] == c && arrayOfSums[currentPlusOneIndex] == a
										&& arrayOfSums[currentPlusTwoIndex] == b)
								|| (arrayOfSums[currentIndex] == c && arrayOfSums[currentPlusOneIndex] == b
										&& arrayOfSums[currentPlusTwoIndex] == a)
								|| (arrayOfSums[currentIndex] == b && arrayOfSums[currentPlusOneIndex] == a
										&& arrayOfSums[currentPlusTwoIndex] == c)
								|| (arrayOfSums[currentIndex] == b && arrayOfSums[currentPlusOneIndex] == c
										&& arrayOfSums[currentPlusTwoIndex] == a)) {
							arrayOfSums[currentIndex] = 0;
							arrayOfSums[currentPlusOneIndex] = 0;
							arrayOfSums[currentPlusTwoIndex] = 0;
						}
					}
				}
				currentIndex += 3;
				currentPlusOneIndex += 3;
				currentPlusTwoIndex += 3;
			}
			firstIndex += 3;
			secondIndex += 3;
			thirdIndex += 3;
		}
	}

	static long[] fillArrayWithSumOfThreeNumbers(int number) {
		long[] temporaryArrayOfSums = new long[(number + 2) * (number + 2) * (number + 2)];
		int currentIndex = 0;
		int currentPlusOneIndex = 1;
		int currentPlusTwoIndex = 2;
		int counter = 0;
		for (int i = 0; i <= number; i++) {
			for (int j = 0; j <= number; j++) {
				for (int k = 0; k <= number; k++) {
					if (i + j + k == number) {
						temporaryArrayOfSums[currentIndex] = i;
						temporaryArrayOfSums[currentPlusOneIndex] = j;
						temporaryArrayOfSums[currentPlusTwoIndex] = k;
						currentIndex += 3;
						currentPlusOneIndex += 3;
						currentPlusTwoIndex += 3;
						counter++;
					}
				}
			}
		}
		temporaryArrayOfSums[temporaryArrayOfSums.length - 1] = counter;
		long[] arrayOfSums = new long[(counter * 3) + 1];
		for (int i = 0; i < arrayOfSums.length; i++) {
			if (i == temporaryArrayOfSums.length) {
				arrayOfSums[i] = temporaryArrayOfSums[temporaryArrayOfSums.length - 1];
			} else {
				arrayOfSums[i] = temporaryArrayOfSums[i];
			}
		}
		return temporaryArrayOfSums;
	}
}
