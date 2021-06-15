import java.util.Arrays;
import java.util.Random;

public class EgészSzámokTömbjébenAdottElemIndexeinekKikeresése {

	public static void main(String[] args) {
		printTheIndexesOfSearchedNumbers(15, 5);
	}

	static int[] initializeTheArray(int sizeOfRandomArray) {
		Random rand = new Random();
		int[] randomArray = new int[sizeOfRandomArray];
		for (int i = 0; i < randomArray.length; i++) {
			randomArray[i] = rand.nextInt(11);
		}
		System.out.println("A létrehezott tömb: ");
		System.out.println(Arrays.toString(randomArray));
		return randomArray;
	}

	static int[] printTheIndexesOfSearchedNumbers(int initializingTheRandomArray, int searchedNumber) {
		int counter = 0;
		boolean found = false;
		int[] arrayOfRandomNumbers = initializeTheArray(initializingTheRandomArray);
		int[] temporaryArrayOfSearchedNumbers = new int[initializingTheRandomArray];
		for (int i = 0; i < arrayOfRandomNumbers.length; i++) {
			if (arrayOfRandomNumbers[i] == searchedNumber) {
				temporaryArrayOfSearchedNumbers[counter] = i;
				counter++;
				found = true;
			}
		}
		int[] arrayOfSearchedNumbers = new int[counter];
		if (found) {
			for (int i = 0; i < arrayOfSearchedNumbers.length; i++) {
				arrayOfSearchedNumbers[i] = temporaryArrayOfSearchedNumbers[i];
			}
			System.out.println("Az alábbi index(eken) található egyezés:");
			System.out.println(Arrays.toString(arrayOfSearchedNumbers));
		} else {
			System.out.println("Nincs egyezés!");
		}
		return arrayOfSearchedNumbers;
	}
}