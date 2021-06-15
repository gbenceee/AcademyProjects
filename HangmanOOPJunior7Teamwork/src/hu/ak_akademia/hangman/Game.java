package hu.ak_akademia.hangman;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) throws FileNotFoundException {
		String[] allWords;

		TextFileReader textFileReader = new TextFileReader();
		allWords = textFileReader.readWords("res/words.txt");

		// System.out.println(Arrays.toString(result));

		RandomWordChooser randomWord = new RandomWordChooser();
		// System.out.println(randomWord.chooseWord(result));

		Scanner scan = new Scanner(System.in);
		String word = randomWord.chooseWord(allWords);
		CorrectLetters correctLetters = new CorrectLetters(word);
		IncorrectLetters incorrectLetters = new IncorrectLetters(word);
		StateOfTheGame stateOfTheGame = new StateOfTheGame(correctLetters, incorrectLetters);
		GameStateChecker gameStateChecker = new GameStateChecker(stateOfTheGame);
		UserInputHandler userInputHandler = new UserInputHandler(scan);
		do {
			System.out.println(stateOfTheGame);
			String letter = userInputHandler.getCharacter("Következő tipp: ");
			correctLetters.revealCorrectLetter(letter);
			incorrectLetters.storeIncorrectLetter(letter);
		} while (gameStateChecker.check()
				.equals(GameStatus.IN_GAME));
		System.out.println((gameStateChecker.check()
				.equals(GameStatus.WON)) ? "Gratulálok! Nyert!" : "Sajnalom, vesztett");
		scan.close();
	}

}
