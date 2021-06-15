import java.util.Scanner;

public class SwitchGyakorlásaElőjelFüggvényFelhasználásával {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Kérlek, adj meg egy számot.");
		int scannedNumber = scan.nextInt();
		float floatingPointSignum = Math.signum(scannedNumber);
		int integerSignum = Math.round(floatingPointSignum);
		switch (integerSignum) {
		case 1:
			System.out.println("A megadott szám pozitív.");
			break;
		case 0:
			System.out.println("A megadott szám nulla.");
			break;
		case -1:
			System.out.println("A megadott szám negatív.");
			break;
		}
		System.out.println(signum(scannedNumber));
	}
	static int signum(int number)
	{
		int result = 0;
		if(number > 0)
		{
			result = 1;
		}
		if(number < 0)
		{
			result = -1;
		}
		if(number == 0)
		{
			result = 0;
		}
		return result;
	}

}
