import java.util.Arrays;
import java.util.Random;

public class RendezésiAlgoritmusokMegvalósítása {

	public static void main(String[] args) {
		Random rand = new Random();
		int[] arrayOfRandomNumbers = new int[15];
		for (int i = 0; i < 15; i++) {
			arrayOfRandomNumbers[i] = rand.nextInt(100);
		}
		System.out.println(Arrays.toString(arrayOfRandomNumbers));
		selectionSort(arrayOfRandomNumbers);
		System.out.println(Arrays.toString(arrayOfRandomNumbers));
		Arrays.sort(arrayOfRandomNumbers);
		System.out.println(Arrays.toString(arrayOfRandomNumbers));
	}

	static void bubbleSort(int[] array) {
		int counter = array.length;
		for (int i = 1; i < array.length; i++) {
			int swapLeftElement = 0;
			int swapRightElement = 0;
			for (int j = 1; j < counter; j++) {
				int rightElement = array[j];
				int leftElement = array[j - 1];
				if (leftElement > rightElement) {
					swapLeftElement = leftElement;
					swapRightElement = rightElement;
					array[j - 1] = swapRightElement;
					array[j] = swapLeftElement;
				}
			}
			counter--;
		}
	}

	static void selectionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int lowest = array[i];
			int elementToBeSwapped = array[i];
			int index = 0;
			boolean swap = false;
			for (int j = i; j < array.length; j++) {
				if (lowest > array[j]) {
					index = j;
					lowest = array[j];
					swap = true;
				}
			}
			if (swap) {
				array[i] = lowest;
				array[index] = elementToBeSwapped;
			}
		}
	}

	static void insertionSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int currentIndex = i;
			int leftElement = array[currentIndex];
			int rightElement = array[i + 1];
			boolean isSwapNecessary = false;
			if (rightElement < leftElement) {
				isSwapNecessary = true;
			}
			boolean isSwapHappened = false;
			if (isSwapNecessary) {
				for (int j = i; j >= 0; j--) {
					if (isSwapHappened) {
						break;
					} else {
						if (rightElement < array[j]) {
							array[j + 1] = array[j];
							if (j == 0) {
								array[j] = rightElement;
							}
						} else {
							array[j + 1] = rightElement;
							isSwapHappened = true;
						}
					}
				}
			}
		}
	}
}
