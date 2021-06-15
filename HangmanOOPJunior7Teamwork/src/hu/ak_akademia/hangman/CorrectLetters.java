package hu.ak_akademia.hangman;

public class CorrectLetters {

	private String chosenWord;
	private boolean[] revealedLetters;

	public CorrectLetters(String chosenWord) {
		this.chosenWord = chosenWord;
		revealedLetters = new boolean[chosenWord.length()];
	}

	public String getChosenWord() {
		return chosenWord;
	}

	public boolean isLetterCorrect(String letter) {
		return chosenWord.contains(letter);
	}

	public void revealCorrectLetter(String letter) {
		if (isLetterCorrect(letter)) {
			for (int i = 0; i < chosenWord.length(); i++) {
				if (chosenWord.charAt(i) == letter.charAt(0)) {
					revealedLetters[i] = true;
				}
			}
		}
	}

	public boolean isAllLetterRevealed() {
		for (boolean revealed : revealedLetters) {
			if (!revealed) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < revealedLetters.length; i++) {
			// if (revealedLetters[i]) {
			// builder.append(chosenWord.charAt(i))
			// .append(" ");
			// } else {
			// builder.append("_ ");
			// }
			builder.append(revealedLetters[i] ? chosenWord.charAt(i) : "_")
					.append(" ");
		}
		return builder.toString()
				.trim();
	}
}
