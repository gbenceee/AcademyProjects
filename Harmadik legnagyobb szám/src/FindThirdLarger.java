import java.util.Arrays;
import java.util.Random;

public class FindThirdLarger {
	static int maxElements = 1_000_000_000;
	static int[] numbers = new int[maxElements];

	public static void main(String[] args) {
		int minValue = Integer.MIN_VALUE;
		initializeArray();
		// printTest(numbers);
		long start = System.currentTimeMillis();
		// System.out.println();
		setActualMaxToMinValue(minValue);
		// printTest(numbers2);
		setActualMaxToMinValue(minValue);
		// System.out.println();
		// printTest(numbers3);
		int thirdMax = Arrays.stream(numbers)
				.max()
				.getAsInt();
		// System.out.println();
		System.out.println(thirdMax);
		// System.out.println(numbers);
		// printTest();
		long end = System.currentTimeMillis();
		float time = (end - start) / 1000;
		System.out.println(time);
		System.out.println("lefutott");
	}

	static void initializeArray() {
		Random randomObj = new Random();
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = randomObj.nextInt();
		}
	}

	static void printTest() {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}

	static void setActualMaxToMinValue(int minValue) {
		int maxValue = Arrays.stream(numbers)
				.max()
				.getAsInt();

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == maxValue) {
				numbers[i] = minValue;
			}
		}
	}
}
