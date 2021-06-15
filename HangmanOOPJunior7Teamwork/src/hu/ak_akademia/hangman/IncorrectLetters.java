package hu.ak_akademia.hangman;

public class IncorrectLetters {
	private String chosenWord;
	private String[] incorrectLetters = new String[10];
	private int numberOfIncorrectLetters;

	public IncorrectLetters(String chosenWord) {
		this.chosenWord = chosenWord;
	}

	public int getNumberOfIncorrectLetters() {
		return numberOfIncorrectLetters;
	}

	public boolean isLetterIncorrect(String letter) {
		return !chosenWord.contains(letter);
	}

	public boolean isAlreadyWrong(String letter) {
		for (int i = 0; i < incorrectLetters.length; i++) {
			if (letter.equals(incorrectLetters[i])) {
				return true;
			}
		}
		return false;
	}

	public void storeIncorrectLetter(String letter) {
		if (isLetterIncorrect(letter) && !isAlreadyWrong(letter)) {
			incorrectLetters[numberOfIncorrectLetters] = letter;
			numberOfIncorrectLetters++;
		}
	}

	public boolean isNoMoreGuessPossible() {
		return numberOfIncorrectLetters >= 10;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Eddigi téves betűk: ");
		for (int i = 0; i < numberOfIncorrectLetters; i++) {
			builder.append(incorrectLetters[i])
					.append(" ");
		}
		return builder.toString()
				.trim();
	}
}
