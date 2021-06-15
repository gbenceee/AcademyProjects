import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lottó {

	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanGuesses = new Scanner(System.in);
		Scanner scanTheNumberOfGuesses = new Scanner(System.in);
		System.out.println("Hány számot sorsoljon a lottó?");
		int numberOfGuesses = scanTheNumberOfGuesses.nextInt();
		int[] arrayLotteryNumbers = new int[numberOfGuesses];
		int[] arrayGivenGuesses = new int[numberOfGuesses];
		System.out.println(numberOfGuesses + " számot fog sorsolni a lottó 0-tól 5-ig. Próbáld meg eltalálni őket!");
		boolean firstGuess = true;
		int guessedIt = 0;
		for(int i = 0; i < numberOfGuesses; i++)
		{
			if(firstGuess)
			{
				System.out.println("Add meg az első tipped!");
				firstGuess = false;
			}
			else
			{
				System.out.println("Add meg a következő tipped!");
			}
			int lotteryNumbers = random.nextInt(6);
			arrayLotteryNumbers[i] = lotteryNumbers;
			int givenGuesses = scanGuesses.nextInt();
			arrayGivenGuesses[i] = givenGuesses;
			if(givenGuesses == lotteryNumbers)
			{
				System.out.println("Talált!");
				guessedIt++;
			}
			else
			{
				System.out.println("Nem talált!");
			}
		}
		
		System.out.println("");
		System.out.println("Ezeket a számokat tippelted: ");
		System.out.print(Arrays.toString(arrayGivenGuesses));
		System.out.println("");
		System.out.println("Ezeket a számokat sorsolta a lottó: ");
		System.out.print(Arrays.toString(arrayLotteryNumbers));
		System.out.println("");
		System.out.println("Ennyi számot találtál el: " + guessedIt);
		
		
		
		
		
		
		
		
		
	}

}
