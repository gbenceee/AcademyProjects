import java.util.Random;
import java.util.Scanner;

public class AkasztófásJáték {

	static Scanner scanner = new Scanner(System.in);
	static final String[] BASIC_WORDS = { "ebéd", "csapat munka", "új autó", "algoritmus", "Atlanti-óceán",
			"csillagcsavarhúzó", "teknősbéka", "tejeskávé", "laptop hűtő", "asszertív emberi jogok", "Coca-Cola",
			"végeselem módszer", "megszentségteleníthetetlenségeskedéseitekért", "Gyűrűk ura" };

	public static void main(String[] args) {
		char[] wrongGuesses = new char[10];
		int numberOfMistakes = 0;
		boolean allInWon = false;
		System.out.println("Köszöntelek az akasztófa programban!");
		System.out.println("A '0' karakter bevitelével választhatsz egy mindent eldöntő tippet.");
		System.out.println("Ilyenkor egy betű helyett egy egész szóra tippelhetsz.");
		System.out.println("Ha nem sikerül eltalálnod, vesztettél.");
		String wordToFind = chooseRandomWord();
		char[] partialSolution = initPartialSolution(wordToFind);
		printPartialSolution(partialSolution);
		do {
			char letter = scanLetterFromUser("Add meg a következő tipped: ");
			if (letter == '0') {
				System.out.println("MINDENT ELDÖNTŐ TIPP!");
				String word = scanner.nextLine();
				if (word.equals(wordToFind)) {
					allInWon = true;
					break;
				} else {
					break;
				}
			}
			if (isLetterCorrect(letter, wordToFind)) {
				revealInPartialSolution(letter, wordToFind, partialSolution);
			} else {
				if (isMistake(wrongGuesses, letter)) {
					storeWrongGuess(letter, wrongGuesses, numberOfMistakes);
					numberOfMistakes++;
				}
			}
			printPartialSolution(partialSolution);
			currentState(numberOfMistakes);
			printWrongLetters(wrongGuesses, numberOfMistakes);
		} while (!isGameOver(numberOfMistakes, partialSolution));
		if (isGameWon(partialSolution)) {
			System.out.println("Gratulálok, nyertél!");
		} else {
			if (allInWon) {
				System.out.println("Gratulálok, nyertél!");
			} else {
				System.out.println("A véletlen szó: " + wordToFind);
				System.out.println("Sajnálom, legközelebb több szerencsét kívánok!");
			}
		}
		System.out.println("Viszlát!");
	}

	static void printWrongLetters(char[] wrongGuesses, int numberOfMistakes) {
		if (numberOfMistakes > 0) {
			System.out.print("Eddigi téves betűk: " + numberOfMistakes + " betű: ");
			for (int i = 0; i < numberOfMistakes; i++) {
				if (i == numberOfMistakes - 1) {
					System.out.println(wrongGuesses[i]);
				} else {
					System.out.print(wrongGuesses[i] + ", ");
				}
			}
		} else {
			System.out.println("Gratulálok, eddig nem volt téves betű!");
		}
	}

	static boolean isGameOver(int numberOfMistakes, char[] partialSolution) {
		return isGameWon(partialSolution) || isGameLost(numberOfMistakes);
	}

	static boolean isGameLost(int numberOfMistakes) {
		return numberOfMistakes >= 10;
	}

	static boolean isGameWon(char[] partialSolution) {
		for (int i = 0; i < partialSolution.length; i++) {
			if (partialSolution[i] == '_') {
				return false;
			}
		}
		return true;
	}

	static void storeWrongGuess(char letter, char[] wrongGuesses, int numberOfMistakes) {
		wrongGuesses[numberOfMistakes] = Character.toLowerCase(letter);
	}

	static void revealInPartialSolution(char letter, String wordToFind, char[] partialSolution) {
		for (int i = 0; i < wordToFind.length(); i++) {
			if (Character.toLowerCase(letter) == Character.toLowerCase(wordToFind.charAt(i))) {
				partialSolution[i] = wordToFind.charAt(i);
			}
		}
	}

	static boolean isLetterCorrect(char letter, String wordToFind) {
		for (int i = 0; i < wordToFind.length(); i++) {
			if (Character.toLowerCase(letter) == Character.toLowerCase(wordToFind.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	static char scanLetterFromUser(String message) {
		String letter;
		do {
			System.out.println(message);
			letter = scanner.nextLine();
			if (isUserInputInvalid(letter)) {

				System.out.println("Kérlek, csak egy betűt adj meg!");
			}
		} while (isUserInputInvalid(letter));
		return letter.charAt(0);
	}

	static boolean isUserInputInvalid(String letter) {
		return letter.length() != 1;
	}

	static void printPartialSolution(char[] partialSolution) {
		for (int i = 0; i < partialSolution.length; i++) {
			System.out.print(partialSolution[i] + " ");
		}
		System.out.println();
	}

	static String chooseRandomWord() {
		Random random = new Random();
		String word = BASIC_WORDS[random.nextInt(BASIC_WORDS.length)];
		return word;
	}

	static char[] initPartialSolution(String wordToFind) {
		int length = wordToFind.length();
		char[] partialSolution = new char[length];
		for (int i = 0; i < partialSolution.length; i++) {
			if (wordToFind.charAt(i) == '-' || wordToFind.charAt(i) == ' ') {
				partialSolution[i] = wordToFind.charAt(i);
			} else {
				partialSolution[i] = '_';
			}
		}
		return partialSolution;
	}

	static boolean isMistake(char[] wrongGuesses, char letter) {
		boolean mistake = false;
		letter = Character.toLowerCase(letter);
		for (int i = 0; i < wrongGuesses.length; i++) {
			if (letter != wrongGuesses[i]) {
				mistake = true;
			} else {
				mistake = false;
				break;
			}
		}
		return mistake;
	}

	static void currentState(int numberOfMistakes) {
		if (numberOfMistakes == 1) {
			System.out.println("         ");
			System.out.println("         ");
			System.out.println("         ");
			System.out.println("         ");
			System.out.println("         ");
			System.out.println("         ");
			System.out.println("         ");
			System.out.println("         ");
			System.out.println("         ");
			System.out.println("         ");
			System.out.println("         ");
			System.out.println("         ");
			System.out.println("_ _");
		}
		if (numberOfMistakes == 2) {
			System.out.println("         ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println("_|_");
		}
		if (numberOfMistakes == 3) {
			System.out.println(" --------");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println("_|_");
		}
		if (numberOfMistakes == 4) {
			System.out.println(" --------");
			System.out.println(" |      |");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println("_|_");
		}
		if (numberOfMistakes == 5) {
			System.out.println(" --------");
			System.out.println(" |      |");
			System.out.println(" |      O ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println("_|_");
		}
		if (numberOfMistakes == 6) {
			System.out.println(" --------");
			System.out.println(" |      |");
			System.out.println(" |      O");
			System.out.println(" |      | ");
			System.out.println(" |      | ");
			System.out.println(" |      | ");
			System.out.println(" |      | ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println("_|_");
		}
		if (numberOfMistakes == 7) {
			System.out.println(" --------");
			System.out.println(" |      |");
			System.out.println(" |      O");
			System.out.println(" |      |  /");
			System.out.println(" |      | /");
			System.out.println(" |      |/ ");
			System.out.println(" |      | ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println("_|_");
		}
		if (numberOfMistakes == 8) {
			System.out.println(" --------");
			System.out.println(" |      |");
			System.out.println(" |      O");
			System.out.println(" |   \\  |  / ");
			System.out.println(" |    \\ | / ");
			System.out.println(" |     \\|/ ");
			System.out.println(" |      |");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println("_|_");
		}
		if (numberOfMistakes == 9) {
			System.out.println(" --------");
			System.out.println(" |      |");
			System.out.println(" |      O");
			System.out.println(" |   \\  |  / ");
			System.out.println(" |    \\ | / ");
			System.out.println(" |     \\|/ ");
			System.out.println(" |      |");
			System.out.println(" |     /");
			System.out.println(" |    /  ");
			System.out.println(" |   /   ");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println("_|_");
		}
		if (numberOfMistakes == 10) {
			System.out.println(" --------");
			System.out.println(" |      |");
			System.out.println(" |      O");
			System.out.println(" |   \\  |  / ");
			System.out.println(" |    \\ | / ");
			System.out.println(" |     \\|/ ");
			System.out.println(" |      |");
			System.out.println(" |     / \\");
			System.out.println(" |    /   \\");
			System.out.println(" |   /     \\");
			System.out.println(" |       ");
			System.out.println(" |       ");
			System.out.println("_|_");
		}
	}

}
