import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ReverseArray {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner scan = new Scanner(System.in);
		System.out.println("Kérlek, add meg, hogy hány elemű legyen a tömb.");
		int scannedNumber = scan.nextInt();
		scan.nextLine();
		int[] array = new int[scannedNumber];
		int number;
		for(int i = 0; i < array.length; i++)
		{
			number = rand.nextInt(11);
			array[i] = number;
			
		}
		System.out.println("Az eredeti tömb: ");
		System.out.print(Arrays.toString(array));
		System.out.println("");
		System.out.println("A megfordított tömb: ");
		System.out.print(Arrays.toString(reverse(array)));

	}
	
	static int[] reverse(int[] array)
	{
		int[] reversedArray = new int[array.length];
		for(int i = array.length - 1, j = 0; i >= 0 && j < array.length ; i--, j++)
		{
			reversedArray[i] = array[j];
		}
		return reversedArray;
	}
}
