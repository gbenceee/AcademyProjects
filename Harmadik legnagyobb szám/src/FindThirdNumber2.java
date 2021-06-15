import java.util.Arrays;
import java.util.Random;

public class FindThirdNumber2 {
	static int maxElements = 1_000_000_000;
	static int[] numbers = new int[maxElements];

	public static void main(String[] args) {
		initializeArray();
		long start = System.currentTimeMillis();

		int[] threeBiggestNumber = { Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE };
		fillThreeBiggestNumber(numbers, threeBiggestNumber);
		System.out.println(threeBiggestNumber[0]);

		long end = System.currentTimeMillis();
		float time = (end - start) / 1000;
		System.out.println(time);
		System.out.println("lefutott");
	}

	static void fillThreeBiggestNumber(int[] numbers, int[] threeBiggestNumber) {
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == threeBiggestNumber[0] || numbers[i] == threeBiggestNumber[1] || numbers[i] == threeBiggestNumber[2]) {
				continue;
			}
			if (numbers[i] > threeBiggestNumber[0]) {
				threeBiggestNumber[0] = numbers[i];
				Arrays.sort(threeBiggestNumber);
			}
		}
	}

	static void initializeArray() {
		Random randomObj = new Random();

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = randomObj.nextInt();

		}

	}
}
