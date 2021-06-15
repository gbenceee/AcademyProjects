import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SzámkitalálósJáték {

	public static void main(String[] args) {
		Random rand = new Random();
		int randomGeneratedNumber = rand.nextInt(100) + 1;
		int guesses = 0;
		int guess;
		welcomeToTheGame();
		System.out.println(randomGeneratedNumber);
		do {
			guess = guessNumber();
			guesses++;
			if (isFirstTry(guess, guesses, randomGeneratedNumber)) {
				System.out.println("Gratulálok, elsőre kitaláltad! Nagyon ügyes vagy.");
				break;
			}
			if (isGuessLower(guess, randomGeneratedNumber)) {
				System.out.println("A tippelt szám kisebb a véletlen számnál.");
			}
			if (isGuessBigger(guess, randomGeneratedNumber)) {
				System.out.println("A tippelt szám nagyobb a véletlen számnál.");
			}
			if (isGuessEqualsNumber(guess, randomGeneratedNumber)) {
				if (isGuessesTooMuch(guesses)) {
					System.out.println(
							"Gratulálok, " + guesses + " tippre volt szükséged, hogy kitaláld a számot. Ügyes vagy!");
					break;
				} else if (isGuessesNotMuch(guesses)) {
					System.out.println("Gratulálok, " + guesses + " tippre volt szükséged, hogy kitaláld a számot.");
					break;
				}
			}
		} while (exit(guess));
		System.out.println("Köszönöm, hogy játszottál!");
	}

	static void welcomeToTheGame() {
		System.out.println("Üdvözöllek a számkitalálós játékban!");
		System.out.println("Gondoltam egy számra 1 és 100 között. Próbáld meg kitalálni!");
		System.out.println("Bármikor kiléphetsz a játékból ha nullát tippelsz.");
	}

	static int guessNumber() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Kérlek, add meg a tipped.");
		int scanNumberFromUser = scan.nextInt();
		return scanNumberFromUser;
	}
	static boolean isGuessEqualsNumber(int guess, int number)
	{
		return guess == number;
	}

	static boolean isFirstTry(int guess, int guesses, int number) {
		return guess == number && guesses == 1;
	}

	static boolean isGuessBigger(int guess, int number) {
		return guess > number;

	}

	static boolean isGuessLower(int guess, int number) {
		return guess < number && guess != 0;

	}
	static boolean isGuessesTooMuch(int guesses)
	{
		return guesses <= 8;
	}
	static boolean isGuessesNotMuch(int guesses)
	{
		return guesses > 8;
	}

	static boolean exit(int guess) {
		return guess != 0;
	}
}
