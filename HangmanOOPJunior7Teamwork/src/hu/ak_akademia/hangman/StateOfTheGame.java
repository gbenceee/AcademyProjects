package hu.ak_akademia.hangman;

public class StateOfTheGame {
	private CorrectLetters correctLetters;
	private IncorrectLetters incorrectLetters;
	private HangmanDrawer hangmanDrawer = new HangmanDrawer();

	public StateOfTheGame(CorrectLetters correctLetters, IncorrectLetters incorrectLetters) {
		this.correctLetters = correctLetters;
		this.incorrectLetters = incorrectLetters;
	}

	public CorrectLetters getCorrectLetters() {
		return correctLetters;
	}

	public IncorrectLetters getIncorrectLetters() {
		return incorrectLetters;
	}

	@Override
	public String toString() {
		hangmanDrawer.printHangman(incorrectLetters.getNumberOfIncorrectLetters());
		StringBuilder builder = new StringBuilder();
		builder.append(correctLetters.toString())
				.append("\n");

		builder.append(incorrectLetters.toString())
				.append("\n");

		return builder.toString();
	}
}
