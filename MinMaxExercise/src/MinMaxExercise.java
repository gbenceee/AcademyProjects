import java.util.Arrays;
import java.util.Scanner;

public class MinMaxExercise {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int elements = 100;
		int number;
		int counter = 0;
		int[] numbers = new int[elements];
		do {
			System.out.println("Kérlek adj meg egy számot.");
			number = scan.nextInt();
			if (number > 0) {
				numbers[counter] = number;
				counter++;
			}
		} while (number != 0);
		int min = numbers[0];
		int max = 0;
		int sum = 0;
		for (int i = 0; i < counter; i++) {
			if (min > numbers[i]) {
				min = numbers[i];
			}
			if (max < numbers[i]) {
				max = numbers[i];
			}
			sum = sum + numbers[i];
		}
		int[] arrayOfNumbers = new int[counter];
		for (int i = 0; i < arrayOfNumbers.length; i++) {
			arrayOfNumbers[i] = numbers[i];
		}

		Arrays.sort(arrayOfNumbers);
		int theNumberBeingCounted = arrayOfNumbers[0];
		int modus = 0;
		int currentHowManyTimes = 0;
		int biggestHowManyTimes = 0;
		for (int i = 0; i < arrayOfNumbers.length; i++) {

			if (arrayOfNumbers[i] == theNumberBeingCounted) {
				biggestHowManyTimes++;
			} else {
				if (biggestHowManyTimes > currentHowManyTimes) {
					currentHowManyTimes = biggestHowManyTimes;
					modus = theNumberBeingCounted;
				}
				theNumberBeingCounted = arrayOfNumbers[i];
				biggestHowManyTimes = 1;
			}

		}
		double average = sum / counter;
		System.out.println("A maximum: " + max);
		System.out.println("A minimum: " + min);
		System.out.println("Az összeg: " + sum);
		System.out.println("Az átlag: " + average);
		System.out.println("A módusz: " + modus);
		int middle = arrayOfNumbers.length / 2;
		int median = (arrayOfNumbers.length / 2) - 1;
		if (arrayOfNumbers.length % 2 > 0) {
			System.out.println("A medián: " + arrayOfNumbers[middle]);
		} else {
			System.out.println("A medián: " + (arrayOfNumbers[median] + arrayOfNumbers[middle]) / 2);
		}

	}

}
