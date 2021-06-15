package hu.ak_akademia.hangman;

import java.util.Random;

public class RandomWordChooser {

	public String chooseWord(String[] words) {
		return words[new Random().nextInt(words.length)];
	}
}
