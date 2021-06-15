import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

	public static void main(String[] args) {
		/*-               0.  1.  2. 3.  4.  5.  6.  7.  8.  9.10. 11.12. 13. 14. */
		// int[] numbers = { 3, 44, 38, 5, 50, 47, 15, 36, 26, 27, 2, 46, 4, 19, 48 };
		int[] numbers = generateRandomNumbers(200_000);
		long start = System.nanoTime();
		long comparisonCounter = 0;
		long swapCounter = 0;
		for (int limit = numbers.length - 1; limit > 0; limit--) {
			for (int i = 0; i < limit; i++) {
				comparisonCounter++;
				if (numbers[i] > numbers[i + 1]) {
					swapCounter++;
					// System.out.println("Csere előtt: " + Arrays.toString(numbers));
					// System.out.println("A(z) " + i + ". elem (" + numbers[i] + ") nagyobb, mint
					// a(z) " + (i + 1) + ". elem (" + numbers[i + 1] + "), ezért kicserélem
					// őket.");
					swap(numbers, i, i + 1);
					// System.out.println("Csere után : " + Arrays.toString(numbers));
					// System.out.println("----------");
				}
			}
		}
		long end = System.nanoTime();
		long elapsed = end - start;
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