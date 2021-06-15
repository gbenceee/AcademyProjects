package hu.ak_akademia.obfuscator;

import java.util.List;

public class TextObfuscator {
	public void iterateThroughTextFromUser(List<String> textFromUserInArray) {
		LetterChecker check = new LetterChecker();
		LetterShuffler shuffle = new LetterShuffler();
		int fromIndex;
		for (int i = 0; i < textFromUserInArray.size(); i++) {
			if (check.isOnlyLetters(textFromUserInArray, i)) {
				fromIndex = i;
				shuffle.chooseCorrectElementsAndShuffleThem(textFromUserInArray, check, fromIndex, i);
			}
		}
	}
}
