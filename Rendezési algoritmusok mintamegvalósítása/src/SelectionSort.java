import java.util.Arrays;
import java.util.Random;

public class SelectionSort {

	public static void main(String[] args) {
		/*-               0.  1.  2. 3.  4.  5.  6.  7.  8.  9.10. 11.12. 13. 14. */
		// int[] numbers = { 3, 44, 38, 5, 50, 47, 15, 36, 26, 27, 2, 46, 4, 19, 48 };
		int[] numbers = generateRandomNumbers(200_000);
		System.out.println(Arrays.toString(numbers));
		long startTime = System.nanoTime();
		long comparisonCounter = 0;
		long swapCounter = 0;
		int minimumValue;
		int minimumIndex;
		for (int start = 0; start < numbers.length - 1; start++) {
			minimumValue = numbers[start];
			minimumIndex = start;
			for (int index = start; index < numbers.length; index++) {
				comparisonCounter++;
				if (minimumValue > numbers[index]) {
					minimumValue = numbers[index];
					minimumIndex = index;
				}
			}
			swap(numbers, start, minimumIndex);
			swapCounter++;
		}

		long endTime = System.nanoTime();
		long elapsed = endTime - startTime;
		System.out.println("Eltelt idő: " + elapsed / 1_000_000L + " ms");
		System.out.println("Összehasonlítások száma: " + comparisonCounter);
		System.out.println("Cserék száma: " + swapCounter);
		System.out.println(Arrays.toString(numbers));
	}

	static int[] generateRandomNumbers(int limit) {
		Random random = new Random();
		int[] numbers = new int[limit];
		for (int i = 0; i < limit; i++) {
			numbers[i] = random.nextInt(1_000_000);
		}
		return numbers;
	}

	static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}