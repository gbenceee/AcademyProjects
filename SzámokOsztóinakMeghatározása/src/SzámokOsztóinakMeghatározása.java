import java.util.Scanner;

public class SzámokOsztóinakMeghatározása {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int scannedNumber;
		do {
			System.out.println("Kérlek, adj meg egy pozitív egész számot.");
			scannedNumber = scan.nextInt();
			if (isPositiveRealNumber(scannedNumber)) {
				System.out.println("Nem egész pozitív számot adál meg.");
			}
		} while (isPositiveRealNumber(scannedNumber));
		System.out.println("A megadott szám: " + scannedNumber);
		for (int i = 1; i <= scannedNumber; i++) {
			System.out.print(i + ": (");
			for (int j = 1; j <= i; j++) {
				if (isDividend(i, j)) {
					if (isOpenRoundBracket(j)) {
						System.out.print(j);
					} else {
						System.out.print(", " + j);
					}
					if (isCloseRoundBracket(j, i)) {
						System.out.print(")");
					}
				}
			}
			System.out.println();
		}
	}
	static boolean isPositiveRealNumber(int number)
	{
		return number <= 0;
	}
	static boolean isCloseRoundBracket(int firstVariable, int secondVariable)
	{
		return firstVariable == secondVariable;
	}
	static boolean isOpenRoundBracket(int variable)
	{
		return variable == 1;
	}
	static boolean isDividend (int firstVariable, int secondVariable)
	{
		return firstVariable % secondVariable == 0;
	}
}
