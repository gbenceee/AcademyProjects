import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SearchInArrayMethod {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		System.out.println("Kérlek, add meg, hogy hány elemű legyen a tömb.");
		int sizeOfArray = scan.nextInt();
		int[] array = new int[sizeOfArray];
		System.out.println("Kérlek, add meg, hogy mely számot keresed.");
		int searchFor = scan.nextInt();
		for (int i = 0; i < array.length; i++) {
			int number = rand.nextInt(11);
			array[i] = number;
		}
		System.out.println(Arrays.toString(array));
		System.out.println(search(array, searchFor));
	}

	static int search(int[] array, int searchFor) {
		for (int i = 0; i < array.length; i++) {
			if (searchFor == array[i]) {
				return i;
			}
		}
		return -1;
	}

}
