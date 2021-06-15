import java.util.Arrays;

public class SortExercise {

	public static void main(String[] args) {
		int[] array = { 3, 44, 38, 5, 50, 47, 15, 36, 26, 27, 2, 46, 4, 19, 48 };
		/* int[] array = { 3, 44, 38, 5, 50, 47, 15, 36, 26, 27, 2, 46, 4, 19, 48 }; */
		insertionSort(array);
		System.out.println(Arrays.toString(array));

	}

	static void mergeSort() {

	}

	static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j != 0; j--) {
				int indexMinusOne = j - 1;
				int bigger = array[j];
				int currentElement = array[j - 1];
				if (array[j] < array[indexMinusOne]) {
					bigger = array[j];
					currentElement = array[j - 1];
					array[j - 1] = bigger;
					array[j] = currentElement;

				}

			}
		}
	}

	static void selectionSort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int lower = array[i];
			int bigger = array[i];
			int index = 0;
			boolean swap = false;
			for (int j = i; j < array.length; j++) {
				if (array[j] < lower) {
					index = j;
					bigger = array[i];
					lower = array[j];
					swap = true;
				}
			}
			if (swap) {
				array[i] = lower;
				array[index] = bigger;
			}
		}
	}

	static void bubbleSort(int[] array) {
		int counter = array.length - 1;
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < counter; j++) {
				int lower = 0;
				int bigger = 0;
				if (array[j] > array[j + 1]) {
					bigger = array[j];
					lower = array[j + 1];
					array[j + 1] = bigger;
					array[j] = lower;
				}
			}
			counter--;
		}
	}

}
