import java.util.Arrays;
import java.util.Random;

public class SzámokMaximumaMinimumaÖsszegeÁtlaga {

	public static void main(String[] args) {
		Random rand = new Random();
		int[] arrayOfRandomNumbers = new int[10];
		for (int i = 0; i < arrayOfRandomNumbers.length; i++) {
			arrayOfRandomNumbers[i] = rand.nextInt(10) + 1;
		}
		Arrays.sort(arrayOfRandomNumbers);
		System.out.println("A minimum: " + min(arrayOfRandomNumbers));
		System.out.println("A maximum: " + max(arrayOfRandomNumbers));
		System.out.println("Az összeg: " + sum(arrayOfRandomNumbers));
		System.out.println("Az átlag: " + average(arrayOfRandomNumbers));
		modus(arrayOfRandomNumbers);
		System.out.println("A medián: " + median(arrayOfRandomNumbers));
	}

	static int sum(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum = sum + array[i];
		}
		return sum;
	}

	static int min(int[] array) {
		int min = array[0];
		for (int i = 0; i < array.length; i++) {
			if (min > array[i]) {
				min = array[i];
			}
		}
		return min;
	}

	static int max(int[] array) {
		int max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		return max;
	}

	static double average(int[] array) {
		double average = (sum(array) * 1.0) / array.length;
		return average;
	}

	static void modus(int[] array) {
		int biggestOccurence = 2;
		int currentOccurence = 0;
		int theNumberBeingCounted = array[0];
		for (int i = 0; i < array.length; i++) {
			if (theNumberBeingCounted != array[i]) {
				theNumberBeingCounted = array[i];
				currentOccurence = 1;
			} else {
				currentOccurence++;
			}
			if (currentOccurence > biggestOccurence) {
				biggestOccurence = currentOccurence;
			}
		}
		theNumberBeingCounted = array[0];
		int[] temporaryModusArray = new int[array.length];
		currentOccurence = 0;
		int counter = 0;
		// -----------------------------------------------------
		for (int i = 0; i < array.length; i++) {
			if (theNumberBeingCounted != array[i]) {
				theNumberBeingCounted = array[i];
				currentOccurence = 1;
			} else {
				currentOccurence++;
			}
			if (currentOccurence == biggestOccurence) {
				temporaryModusArray[i] = array[i];
				counter++;
			}
		}
		Arrays.sort(temporaryModusArray);
		int[] modusArray = new int[counter];
		int currentElement = 0;
		for (int i = 0; i < temporaryModusArray.length; i++) {
			if (temporaryModusArray[i] != 0) {
				modusArray[currentElement] = temporaryModusArray[i];
				currentElement++;
			}
		}
		if (modusArray.length == 1) {
			for (int i = 0; i < modusArray.length; i++) {
				System.out.println("A módusz: " + modusArray[i]);
			}
		} else if (modusArray.length > 1) {
			boolean first = true;
			System.out.print("Több módusz szerepel az elemek között: ");
			for (int i = 0; i < modusArray.length; i++) {
				if (first) {
					System.out.print(modusArray[i]);
					first = false;
				} else {
					System.out.print(", " + modusArray[i]);
				}
			}
			System.out.println();
		} else if (modusArray.length == 0) {
			System.out.println("Az összes elem ugyanannyiszor fordul elő.");
		}
	}

	static int median(int[] array) {
		int median = 0;
		median = array[array.length / 2];
		if (array.length % 2 == 0) {
			median = (array[(array.length / 2) - 1] + array[array.length / 2]) / 2;
		}
		return median;
	}
}
