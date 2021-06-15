
public class TömbHasználatánakGyakorlása {

	public static void main(String[] args) {
		int[] finalArray = new int[40];
		fillTheFirstTenElements(20, finalArray);
		fillTheSecondTenElements(130, finalArray);
		fillTheThirdTenElements(1550, finalArray);
		fillTheFourthTenElements(-1000000, finalArray);
		printOutInOrder(finalArray);
		System.out.println("--------------------------------------------------------------");
		printOutInReverse(finalArray);
		System.out.println("--------------------------------------------------------------");
		printOutSeperatedWithCommaAndSpace(finalArray);
		System.out.println();
		System.out.println("--------------------------------------------------------------");
		printOutSeperatedWithCommaAndSpaceInReverse(finalArray);
		System.out.println();
		System.out.println("--------------------------------------------------------------");
	}

	static void fillTheFirstTenElements(int firstElement, int[] finalArray) {
		int from = 0;
		int to = 10;
		for (int i = from; i < to; i++) {
			finalArray[i] = firstElement;
			firstElement++;
		}
	}

	static void fillTheSecondTenElements(int firstElement, int[] finalArray) {
		int from = 10;
		int to = 20;
		for (int i = from; i < to; i++) {
			finalArray[i] = firstElement;
			firstElement += 2;
		}
	}

	static void fillTheThirdTenElements(int firstElement, int[] finalArray) {
		int from = 20;
		int to = 30;
		for (int i = from; i < to; i++) {
			finalArray[i] = firstElement;
			firstElement -= 10;
		}
	}

	static void fillTheFourthTenElements(int firstElement, int[] finalArray) {
		int from = 30;
		int to = 40;
		int currentNumberOfIndex = firstElement;
		for (int i = from; i < to; i++) {
			finalArray[i] = currentNumberOfIndex;
			currentNumberOfIndex = currentNumberOfIndex * 2;
		}
	}

	static void printOutInOrder(int[] finalArray) {
		System.out.println("A tömb elemei:");
		for (int i = 0; i < finalArray.length; i++) {
			System.out.println(finalArray[i]);
		}
	}

	static void printOutInReverse(int[] finalArray) {
		System.out.println("A tömb elemei fordított sorrendben:");
		for (int i = finalArray.length - 1; i >= 0; i--) {
			System.out.println(finalArray[i]);
		}
	}

	static void printOutSeperatedWithCommaAndSpace(int[] finalArray) {
		System.out.println("A tömb elemei vesszővel, szóközzel elválasztva:");
		boolean first = true;
		for (int i = 0; i < finalArray.length; i++) {
			if (first) {
				System.out.print(finalArray[i]);
				first = false;
			} else {
				System.out.print(", " + finalArray[i]);
			}
		}
	}

	static void printOutSeperatedWithCommaAndSpaceInReverse(int[] finalArray) {
		System.out.println("A tömb elemei vesszővel, szóközzel elválasztva fordított, sorrendben:");
		boolean first = true;
		for (int i = finalArray.length - 1; i >= 0; i--) {
			if (first) {
				System.out.print(finalArray[i]);
				first = false;
			} else {
				System.out.print(", " + finalArray[i]);
			}
		}
	}
}
