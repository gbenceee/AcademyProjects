package hu.ak_akademia.obfuscator;

import java.util.Collections;
import java.util.List;

public class LetterShuffler {
	public void chooseCorrectElementsAndShuffleThem(List<String> textFromUserInArray, LetterChecker check, int fromIndex, int i) {
		int toIndex;
		for (int j = i; j < textFromUserInArray.size(); j++) {
			if (!check.isOnlyLetters(textFromUserInArray, j)) {
				toIndex = j;
				i = j;
				Collections.shuffle(textFromUserInArray.subList(fromIndex, toIndex));
				break;
			}
		}
	}
}
