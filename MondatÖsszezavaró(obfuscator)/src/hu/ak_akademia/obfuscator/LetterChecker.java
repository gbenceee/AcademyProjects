package hu.ak_akademia.obfuscator;

import java.util.List;

public class LetterChecker {
	public boolean isOnlyLetters(List<String> textFromUserInArray, int i) {
		return textFromUserInArray.get(i).matches("[A-Za-zÀ-ɏ]*");
	}
}
