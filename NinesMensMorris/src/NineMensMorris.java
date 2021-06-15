import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NineMensMorris {

	static final char X = '○';
	static final char O = '●';

	public static void main(String[] args) throws FileNotFoundException {
		char[][] initialBoard = initBoard();
		// @formatter:off
        char[] fields =               {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X'};
        final int [][] coordinates = {{ 0,   0,   0,   2,   2,   2,   4,   4,   4,   6,   6,   6,   6,   6,   6,   8,   8,   8,  10,  10,  10,  12,  12,  12},
                                      { 0,  12,  24,   4,  12,  20,   8,  12,  16,   0,   4,   8,  16,  20,  24,   8,  12,  16,   4,  12,  20,   0,  12,  24}};
        char[] pieces =               {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        final char [][] neighbours =  {{'B', 'J'},{'A', 'C', 'E'},{'B', 'O'},{'E', 'K'},{'D', 'F', 'B','H'},{'E', 'N'},{'H', 'L'},{'G', 'I', 'E'},{'H', 'M'},{'A', 'K', 'V'},{'D', 'L', 'S', 'J'},{'G', 'P','K'},{'I', 'R','N'},{'F', 'M','O','U'},{'C', 'N','X'},{'L','Q'},{'P', 'R','T'},{'M', 'Q'},{'K', 'T'},{'Q', 'S','U','W'},{'N', 'T'},{'W', 'J'},{'T', 'V','X'},{'O', 'W'}};
        // @formatter:on
		int rounds = 0;
		char[] players = { X, O };
		int[] piecesInHands = { 9, 9 };
		PlayerPhase[] playerPhases = { PlayerPhase.PLACING_PIECES, PlayerPhase.PLACING_PIECES };
		char currentPlayer = players[rounds % 2];
		char currentEnemyPlayer = players[1 - rounds % 2];
		PlayerPhase currentPlayerPhase = playerPhases[rounds % 2];
		printBoard(coordinates, pieces, initialBoard);
		do {
			char nextMove = getFreePositionFromUser(currentPlayer + " játékos következik: ", pieces, fields);
			putPiece(nextMove, fields, pieces, currentPlayer);
			int mills = getNumberOfMills(nextMove, fields, pieces, currentPlayer);
			if (mills > 0) {
				System.out.println(mills + " malmod van.");
			}
			for (int i = 0; i < mills; i++) {
				printBoard(coordinates, pieces, initialBoard);
				char nextToRemove = getPositionFromUserToRemovePiece("Melyik korongot veszed le?", pieces, fields, currentEnemyPlayer);
				removePiece(nextToRemove, fields, pieces);
			}
			piecesInHands[rounds % 2] -= 1;
			printBoard(coordinates, pieces, initialBoard);
			rounds++;
			currentPlayer = players[rounds % 2];
			currentEnemyPlayer = players[1 - rounds % 2];
			currentPlayerPhase = playerPhases[rounds % 2];

		} while (piecesInHands[0] > 0 || piecesInHands[1] > 0);

		playerPhases[0] = PlayerPhase.MOVING_PIECES;
		playerPhases[1] = PlayerPhase.MOVING_PIECES;
		currentPlayerPhase = PlayerPhase.MOVING_PIECES;
		char whoWon = ' ';
		int roundsOfNonChange = 0;
		while (isMovePossible(currentPlayer, pieces, fields, neighbours) && whoWon == ' ' && roundsOfNonChange <= 25) {
			System.out.println(currentPlayer + " játékos következik!");
			char pieceToMoveFrom = getPositionFromUserToMoveFrom(pieces, fields, currentPlayer, currentPlayerPhase, neighbours);
			char pieceToMoveTo = getPositionFromUserToMoveTo(pieces, fields, pieceToMoveFrom, currentPlayerPhase, neighbours);
			putPiece(pieceToMoveTo, fields, pieces, currentPlayer);
			removePiece(pieceToMoveFrom, fields, pieces);

			printBoard(coordinates, pieces, initialBoard);
			int mills = getNumberOfMills(pieceToMoveTo, fields, pieces, currentPlayer);
			if (mills > 0) {
				System.out.println(mills + " malmod van.");
			}

			for (int i = 0; i < mills; i++) {
				printBoard(coordinates, pieces, initialBoard);
				char nextToRemove = getPositionFromUserToRemovePiece("Melyik korongot veszed le?", pieces, fields, currentEnemyPlayer);
				removePiece(nextToRemove, fields, pieces);
				roundsOfNonChange = 0;
			}
			printBoard(coordinates, pieces, initialBoard);

			int enemyPieces = countPieces(currentEnemyPlayer, pieces);
			if (enemyPieces == 3) {
				playerPhases[1 - rounds % 2] = PlayerPhase.FLYING;
			}
			if (enemyPieces < 3) {
				whoWon = currentPlayer;
			}
			rounds++;
			roundsOfNonChange++;
			currentPlayer = players[rounds % 2];
			currentEnemyPlayer = players[1 - rounds % 2];
			currentPlayerPhase = playerPhases[rounds % 2];
		}
		System.out.println(whoWon == ' ' ? "Döntetlen" : "Győztes: " + whoWon);
	}

	static char getPositionFromUserToMoveTo(char[] pieces, char[] fields, char pieceToMoveFrom, PlayerPhase currentPlayerPhase, char[][] neighbours) {
		do {
			char position = getFreePositionFromUser("Válasszon, hogy hová szeretne lépni!", pieces, fields);
			if (PlayerPhase.MOVING_PIECES.equals(currentPlayerPhase)) {
				int index = getIndexOfPosition(pieceToMoveFrom, fields);
				char[] neighboursOfPosition = neighbours[index];
				for (int i = 0; i < neighboursOfPosition.length; i++) {
					if (position == neighboursOfPosition[i]) {
						return position;
					}
				}
				System.out.println("Ez nem egy szomszédos mező!");
			} else if (PlayerPhase.FLYING.equals(currentPlayerPhase)) {
				return position;
			}
		} while (true);
	}

	static int countPieces(char player, char[] pieces) {
		int count = 0;
		for (int i = 0; i < pieces.length; i++) {
			if (pieces[i] == player) {
				count++;
			}
		}
		return count;
	}

	static char[] getNeighboursOf(char position, char[] fields, char[][] neighbours) {
		int index = getIndexOfPosition(position, fields);
		return neighbours[index];
	}

	static char getPositionFromUserToMoveFrom(char[] pieces, char[] fields, char currentPlayer, PlayerPhase currentPlayerPhase, char[][] neighbours) {
		do {
			char position = getPositionFromUserWithBasicValidation("Válaszon egyet a lerakott bábúi közül!");
			int index = getIndexOfPosition(position, fields);
			if (pieces[index] == currentPlayer) {
				if (currentPlayerPhase.equals(PlayerPhase.MOVING_PIECES)) {
					if (isNeighbourPositionAvailable(position, pieces, fields, neighbours)) {
						return position;
					}
					System.out.println("Ezt a bábut nem lehet mozgatni!");
				} else if (currentPlayerPhase.equals(PlayerPhase.FLYING)) {
					return position;
				}
			} else {
				System.out.println("Ezen a mezőn nincs bábud!");
			}
		} while (true);
	}

	static boolean isMovePossible(char currentPlayer, char[] pieces, char[] fields, char[][] neighbours) {
		for (int i = 0; i < pieces.length; i++) {
			if (pieces[i] == currentPlayer) {
				for (int j = 0; j < neighbours[i].length; j++) {
					if (pieces[getIndexOfPosition(neighbours[i][j], fields)] == ' ') {
						return true;
					}
				}
			}
		}
		return false;
	}

	static boolean isNeighbourPositionAvailable(char position, char[] pieces, char[] fields, char[][] neighbours) {
		int index = getIndexOfPosition(position, fields);
		char[] neighboursOfPosition = neighbours[index];
		for (int i = 0; i < neighboursOfPosition.length; i++) {
			if (pieces[getIndexOfPosition(neighboursOfPosition[i], fields)] == ' ') {
				return true;
			}
		}
		return false;
	}

	static void removePiece(char nextToRemove, char[] fields, char[] pieces) {
		int index = getIndexOfPosition(nextToRemove, fields);
		pieces[index] = ' ';
	}

	static char getPositionFromUserToRemovePiece(String message, char[] pieces, char[] fields, char currentEnemyPlayer) {
		while (true) {
			char position = getPositionFromUserWithBasicValidation(message);
			int index = getIndexOfPosition(position, fields);
			if (pieces[index] != currentEnemyPlayer) {
				System.out.println("A megadott mező nem az ellenfél korongját tartalmazza.");
				continue;
			}
			if (getNumberOfMills(position, fields, pieces, currentEnemyPlayer) == 0) {
				return position;
			}
			if (isPlayersPiecesOnlyInMills(pieces, fields, currentEnemyPlayer)) {
				return position;
			}
			System.out.println("Az ellenfél korongja malomban van, kérlek válassz másikat!");
		}
	}

	static boolean isPlayersPiecesOnlyInMills(char[] pieces, char[] fields, char currentEnemyPlayer) {
		for (int i = 0; i < fields.length; i++) {
			if (pieces[i] == currentEnemyPlayer) {
				if (getNumberOfMills(fields[i], fields, pieces, currentEnemyPlayer) == 0) {
					return false;
				}
			}
		}
		return true;
	}

	static int getNumberOfMills(char nextMove, char[] fields, char[] pieces, char currentPlayer) {
		int mill = 0;
		switch (nextMove) {
		case 'A':
			if (pieces[getIndexOfPosition('B', fields)] == currentPlayer && pieces[getIndexOfPosition('C', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('J', fields)] == currentPlayer && pieces[getIndexOfPosition('V', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'B':
			if (pieces[getIndexOfPosition('A', fields)] == currentPlayer && pieces[getIndexOfPosition('C', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('E', fields)] == currentPlayer && pieces[getIndexOfPosition('H', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'C':
			if (pieces[getIndexOfPosition('A', fields)] == currentPlayer && pieces[getIndexOfPosition('B', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('O', fields)] == currentPlayer && pieces[getIndexOfPosition('X', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'D':
			if (pieces[getIndexOfPosition('E', fields)] == currentPlayer && pieces[getIndexOfPosition('F', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('K', fields)] == currentPlayer && pieces[getIndexOfPosition('S', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'E':
			if (pieces[getIndexOfPosition('D', fields)] == currentPlayer && pieces[getIndexOfPosition('F', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('B', fields)] == currentPlayer && pieces[getIndexOfPosition('H', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'F':
			if (pieces[getIndexOfPosition('D', fields)] == currentPlayer && pieces[getIndexOfPosition('E', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('N', fields)] == currentPlayer && pieces[getIndexOfPosition('U', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'G':
			if (pieces[getIndexOfPosition('H', fields)] == currentPlayer && pieces[getIndexOfPosition('I', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('L', fields)] == currentPlayer && pieces[getIndexOfPosition('P', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'H':
			if (pieces[getIndexOfPosition('G', fields)] == currentPlayer && pieces[getIndexOfPosition('I', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('B', fields)] == currentPlayer && pieces[getIndexOfPosition('E', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'I':
			if (pieces[getIndexOfPosition('G', fields)] == currentPlayer && pieces[getIndexOfPosition('H', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('M', fields)] == currentPlayer && pieces[getIndexOfPosition('R', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'J':
			if (pieces[getIndexOfPosition('A', fields)] == currentPlayer && pieces[getIndexOfPosition('V', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('K', fields)] == currentPlayer && pieces[getIndexOfPosition('L', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'K':
			if (pieces[getIndexOfPosition('D', fields)] == currentPlayer && pieces[getIndexOfPosition('S', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('J', fields)] == currentPlayer && pieces[getIndexOfPosition('L', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'L':
			if (pieces[getIndexOfPosition('G', fields)] == currentPlayer && pieces[getIndexOfPosition('P', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('J', fields)] == currentPlayer && pieces[getIndexOfPosition('K', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'M':
			if (pieces[getIndexOfPosition('I', fields)] == currentPlayer && pieces[getIndexOfPosition('R', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('N', fields)] == currentPlayer && pieces[getIndexOfPosition('O', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'N':
			if (pieces[getIndexOfPosition('F', fields)] == currentPlayer && pieces[getIndexOfPosition('U', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('M', fields)] == currentPlayer && pieces[getIndexOfPosition('O', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'O':
			if (pieces[getIndexOfPosition('C', fields)] == currentPlayer && pieces[getIndexOfPosition('X', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('M', fields)] == currentPlayer && pieces[getIndexOfPosition('N', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'P':
			if (pieces[getIndexOfPosition('G', fields)] == currentPlayer && pieces[getIndexOfPosition('L', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('Q', fields)] == currentPlayer && pieces[getIndexOfPosition('R', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'Q':
			if (pieces[getIndexOfPosition('P', fields)] == currentPlayer && pieces[getIndexOfPosition('R', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('T', fields)] == currentPlayer && pieces[getIndexOfPosition('W', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'R':
			if (pieces[getIndexOfPosition('P', fields)] == currentPlayer && pieces[getIndexOfPosition('Q', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('I', fields)] == currentPlayer && pieces[getIndexOfPosition('M', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'S':
			if (pieces[getIndexOfPosition('D', fields)] == currentPlayer && pieces[getIndexOfPosition('K', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('T', fields)] == currentPlayer && pieces[getIndexOfPosition('U', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'T':
			if (pieces[getIndexOfPosition('S', fields)] == currentPlayer && pieces[getIndexOfPosition('U', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('Q', fields)] == currentPlayer && pieces[getIndexOfPosition('W', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'U':
			if (pieces[getIndexOfPosition('F', fields)] == currentPlayer && pieces[getIndexOfPosition('N', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('S', fields)] == currentPlayer && pieces[getIndexOfPosition('T', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'V':
			if (pieces[getIndexOfPosition('A', fields)] == currentPlayer && pieces[getIndexOfPosition('J', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('W', fields)] == currentPlayer && pieces[getIndexOfPosition('X', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'W':
			if (pieces[getIndexOfPosition('V', fields)] == currentPlayer && pieces[getIndexOfPosition('X', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('Q', fields)] == currentPlayer && pieces[getIndexOfPosition('T', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'X':
			if (pieces[getIndexOfPosition('V', fields)] == currentPlayer && pieces[getIndexOfPosition('W', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('C', fields)] == currentPlayer && pieces[getIndexOfPosition('O', fields)] == currentPlayer) {
				mill++;
			}
			break;
		}
		return mill;
	}

	static char getFreePositionFromUser(String message, char[] pieces, char[] fields) {
		while (true) {
			char position = getPositionFromUserWithBasicValidation(message);
			int index = getIndexOfPosition(position, fields);
			if (pieces[index] == ' ') {
				return position;
			}
			System.out.println("A megadott mező nem üres.");
		}
	}

	static int getIndexOfPosition(char position, char[] fields) {
		for (int i = 0; i < fields.length; i++) {
			if (fields[i] == position) {
				return i;
			}
		}
		return -1;
	}

	static void putPiece(char nextMove, char[] fields, char[] pieces, char currentPlayer) {
		int index = getIndexOfPosition(nextMove, fields);
		pieces[index] = currentPlayer;
	}

	static char getPositionFromUserWithBasicValidation(String message) {
		String position;
		Scanner scanner = new Scanner(System.in);
		ValidationResult validationResult;
		do {
			System.out.println(message);
			position = scanner.nextLine()
					.toUpperCase();
			validationResult = isInputValid(position);
			switch (validationResult) {
			case INVALID_LENGTH:
				System.out.println("Figyelem! A pozició csak egy betűből állhat!");
				break;
			case INVALID_LETTER:
				System.out.println("Figyelem! A pozició nem megfelelő!");
				break;
			}
		} while (!validationResult.equals(ValidationResult.OK));
		return position.charAt(0);
	}

	static ValidationResult isInputValid(String position) {
		if (position.length() != 1) {
			return ValidationResult.INVALID_LENGTH;
		}
		char nextMove = position.charAt(0);
		if (nextMove < 65 || nextMove > 88) {
			return ValidationResult.INVALID_LETTER;
		}
		return ValidationResult.OK;
	}

	static char[][] initBoard() throws FileNotFoundException {
		Scanner in = new Scanner(new File("resources/board.txt"));
		char[][] board = new char[13][55];
		int row = 0;
		while (in.hasNextLine()) {
			String line = in.nextLine();
			for (int column = 0; column < line.length(); column++) {
				board[row][column] = line.charAt(column);
			}
			row++;
		}
		in.close();
		return board;
	}

	static void printBoard(int[][] coordinates, char[] pieces, char[][] initialBoard) {
		char[][] board = new char[13][54];
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[row].length; column++) {
				board[row][column] = initialBoard[row][column];
			}
		}
		for (int i = 0; i < pieces.length; i++) {
			if (pieces[i] != ' ') {
				int row = coordinates[0][i];
				int column = coordinates[1][i];
				board[row][column] = pieces[i];
			}
		}
		for (char[] column : board) {
			for (char element : column) {
				System.out.print(element);
			}
			System.out.println();
		}
	}

}
