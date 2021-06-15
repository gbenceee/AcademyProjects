package hu.ak_akademia.hangman;

public class GameStateChecker {
	private StateOfTheGame stateOfTheGame;

	public GameStateChecker(StateOfTheGame stateOfTheGame) {
		this.stateOfTheGame = stateOfTheGame;
	}

	public GameStatus check() {
		if (stateOfTheGame.getCorrectLetters()
				.isAllLetterRevealed()) {
			return GameStatus.WON;
		} else if (stateOfTheGame.getIncorrectLetters()
				.isNoMoreGuessPossible()) {
			return GameStatus.LOST;
		}
		return GameStatus.IN_GAME;
	}
}
