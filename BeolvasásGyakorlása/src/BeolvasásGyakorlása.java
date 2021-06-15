import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BeolvasásGyakorlása {

	public static void main(String[] args) {
		
		Scanner read = new Scanner(System.in);
		System.out.println("Hogy hívnak?");
		String name = read.nextLine();
		System.out.println("Szia " + name + "!");
		
		Scanner scanTheNumbers = new Scanner(System.in);
		Scanner scanThePieces = new Scanner(System.in);
		System.out.println("Hány elemű legyen a tömb?");
		int numbersVariable = scanTheNumbers.nextInt();
		int[] givenNumbers = new int[numbersVariable];
		for(int i = 0; i < numbersVariable; i++)
		{
			int iVariable = i + 1;
			System.out.println("Add meg a " + iVariable + ". elemet!");
			int arrayPieces = scanThePieces.nextInt();
			givenNumbers[i] = arrayPieces;
		}
		System.out.print("Ezeket a számokat adtad meg: ");
		System.out.println(Arrays.toString(givenNumbers));
		System.out.println("");
		System.out.print("A megadott tömb elemeinek kiírása egymás mellé vesszővel és szóközzel elválasztva: ");
		boolean comma = true;
		for(int i = 0; i < numbersVariable; i ++)
		{
			if(comma)
			{
				System.out.print(givenNumbers[i]);
				comma = false;
			}
			else
			{
				System.out.print(", " + givenNumbers[i]);
			}
		}
		System.out.println("");
		System.out.println("");
		System.out.print("A megadott tömb elemeinek kiírása fordítva egymás mellé vesszővel és szóközzel elválasztva: ");
		boolean comma2 = true;
		for(int i = numbersVariable - 1; i >= 0 ; i --)
		{
			if(comma2)
			{
				System.out.print(givenNumbers[i]);
				comma2 = false;
			}
			else
			{
				System.out.print(", " + givenNumbers[i]);
			}
		}
		System.out.println("");
		System.out.println("");
		
		System.out.print("A megadott tömb hárommal osztható elemeinek kiírása egymás mellé vesszővel és szóközzel elválasztva: ");
		boolean comma3 = true;
		for(int i = 0; i < numbersVariable ; i ++)
		{
			if(givenNumbers[i] % 3 == 0)
			{
				if(comma3)
				{
					System.out.print(givenNumbers[i]);
					comma3 = false;
				}
				else
				{
					System.out.print(", " + givenNumbers[i]);
				}
			}
		}
		System.out.println("");
		System.out.println("");
		
		
		
		
		
		
		
		
		System.out.println("Program vége.");
		
		
	}

}
