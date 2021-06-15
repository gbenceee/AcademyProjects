import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class MalomJáték {
	static final char X = '○';
	static final char O = '●';

	public static void main(String[] args) throws FileNotFoundException {
		char[][] initialBoard = initBoard();
		// @formatter:off
        char[] fields =               {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X'};
        final int [][] coordinates = {{ 0,   0,   0,   2,   2,   2,   4,   4,   4,   6,   6,   6,   6,   6,   6,   8,   8,   8,  10,  10,  10,  12,  12,  12},
                                      { 0,  12,  24,   4,  12,  20,   8,  12,  16,   0,   4,   8,  16,  20,  24,   8,  12,  16,   4,  12,  20,   0,  12,  24}};
        char[] pieces =               {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        // @formatter:on
		int rounds = 0;
		char[] players = { X, O };
		int[] piecesInHands = { 9, 9 };
		PlayerPhase[] playerPhases = { PlayerPhase.PLACING_PIECES, PlayerPhase.PLACING_PIECES };
		char currentPlayer = players[rounds % 2];
		char currentEnemyPlayer = players[1 - rounds % 2];
		char nextToRemove = 0;
		PlayerPhase currentPlayerPhase = playerPhases[rounds % 2];
		printBoard(coordinates, pieces, initialBoard);
		do {
			char nextMove = getPositionFromUserPlacingPieces(currentPlayer + " játékos következik: ", pieces, fields);
			putPiece(nextMove, fields, pieces, currentPlayer);
			int mills = getNumberOfMills(nextMove, fields, pieces, currentPlayer);

			for (int i = 0; i < mills; i++) {
				if (isEveryEnemyPieceInMill(pieces, currentEnemyPlayer, fields)) {
					nextToRemove = getPositionFromUserToRemovePiece("Melyik korongot veszed le?", pieces, fields,
							currentEnemyPlayer);
					removePiece(nextToRemove, fields, pieces);
				} else {
					do {
						nextToRemove = getPositionFromUserToRemovePiece("Melyik korongot veszed le?", pieces, fields,
								currentEnemyPlayer);
						if (isNextToRemoveInMill(nextToRemove, fields, currentEnemyPlayer, pieces)) {
							System.out.println(
									"A korong malomban áll. Csak akkor vehetsz le korongot ha az nincs malomban.");
						}
					} while (isNextToRemoveInMill(nextToRemove, fields, currentEnemyPlayer, pieces));
					removePiece(nextToRemove, fields, pieces);
				}
			}

			piecesInHands[rounds % 2] -= 1;
			printBoard(coordinates, pieces, initialBoard);
			rounds++;
			currentPlayer = players[rounds % 2];
			currentEnemyPlayer = players[1 - rounds % 2];
		} while (piecesInHands[0] > 0 || piecesInHands[1] > 0);
	}

	static void removePiece(char nextToRemove, char[] fields, char[] pieces) {
		int index = getIndexOfPosition(nextToRemove, fields);
		pieces[index] = ' ';
	}

	static char getPositionFromUserToRemovePiece(String message, char[] pieces, char[] fields,
			char currentEnemyPlayer) {
		while (true) {
			char position = getPositionFromUserWithBasicValidation(message);
			int index = getIndexOfPosition(position, fields);
			if (pieces[index] == currentEnemyPlayer) {
				return position;
			}
			System.out.println("A megadott mező nem az ellenfél korongját tartalmazza.");
		}
	}

	static boolean isNextToRemoveInMill(char nextToRemove, char[] fields, char currentEnemyPlayer, char[] pieces) {
		boolean isMill = false;
		switch (nextToRemove) {
		case 'A':
			if (pieces[getIndexOfPosition('B', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('C', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			if (pieces[getIndexOfPosition('J', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('V', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			break;
		case 'B':
			if (pieces[getIndexOfPosition('A', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('C', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			if (pieces[getIndexOfPosition('E', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('H', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			break;
		case 'C':
			if (pieces[getIndexOfPosition('A', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('B', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			if (pieces[getIndexOfPosition('O', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('X', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			break;
		case 'D':
			if (pieces[getIndexOfPosition('E', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('F', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			if (pieces[getIndexOfPosition('K', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('S', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			break;
		case 'E':
			if (pieces[getIndexOfPosition('D', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('F', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			if (pieces[getIndexOfPosition('K', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('S', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			break;
		case 'F':
			if (pieces[getIndexOfPosition('D', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('E', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			if (pieces[getIndexOfPosition('N', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('U', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			break;
		case 'G':
			if (pieces[getIndexOfPosition('H', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('I', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			if (pieces[getIndexOfPosition('L', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('P', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			break;
		case 'H':
			if (pieces[getIndexOfPosition('G', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('I', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			if (pieces[getIndexOfPosition('B', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('E', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			break;
		case 'I':
			if (pieces[getIndexOfPosition('G', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('H', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			if (pieces[getIndexOfPosition('M', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('R', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			break;
		case 'J':
			if (pieces[getIndexOfPosition('A', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('V', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			if (pieces[getIndexOfPosition('K', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('L', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			break;
		case 'K':
			if (pieces[getIndexOfPosition('D', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('S', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			if (pieces[getIndexOfPosition('J', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('L', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			break;
		case 'L':
			if (pieces[getIndexOfPosition('G', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('P', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			if (pieces[getIndexOfPosition('J', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('K', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			break;
		case 'M':
			if (pieces[getIndexOfPosition('I', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('R', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			if (pieces[getIndexOfPosition('N', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('O', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			break;
		case 'N':
			if (pieces[getIndexOfPosition('F', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('U', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			if (pieces[getIndexOfPosition('M', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('O', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			break;
		case 'O':
			if (pieces[getIndexOfPosition('C', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('X', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			if (pieces[getIndexOfPosition('M', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('N', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			break;
		case 'P':
			if (pieces[getIndexOfPosition('G', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('L', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			if (pieces[getIndexOfPosition('Q', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('R', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			break;
		case 'Q':
			if (pieces[getIndexOfPosition('P', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('R', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			if (pieces[getIndexOfPosition('T', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('W', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			break;
		case 'R':
			if (pieces[getIndexOfPosition('P', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('Q', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			if (pieces[getIndexOfPosition('I', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('M', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			break;
		case 'S':
			if (pieces[getIndexOfPosition('D', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('K', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			if (pieces[getIndexOfPosition('T', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('U', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			break;
		case 'T':
			if (pieces[getIndexOfPosition('S', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('U', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			if (pieces[getIndexOfPosition('Q', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('W', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			break;
		case 'U':
			if (pieces[getIndexOfPosition('F', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('N', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			if (pieces[getIndexOfPosition('S', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('T', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			break;
		case 'V':
			if (pieces[getIndexOfPosition('A', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('J', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			if (pieces[getIndexOfPosition('W', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('X', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			break;
		case 'W':
			if (pieces[getIndexOfPosition('V', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('X', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			if (pieces[getIndexOfPosition('Q', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('T', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			break;
		case 'X':
			if (pieces[getIndexOfPosition('V', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('W', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			if (pieces[getIndexOfPosition('C', fields)] == currentEnemyPlayer
					&& pieces[getIndexOfPosition('O', fields)] == currentEnemyPlayer) {
				isMill = true;
			}
			break;
		}
		return isMill;
	}

	static int getNumberOfMills(char nextMove, char[] fields, char[] pieces, char currentPlayer) {
		int mill = 0;
		switch (nextMove) {
		case 'A':
			if (pieces[getIndexOfPosition('B', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('C', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('J', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('V', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'B':
			if (pieces[getIndexOfPosition('A', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('C', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('E', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('H', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'C':
			if (pieces[getIndexOfPosition('A', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('B', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('O', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('X', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'D':
			if (pieces[getIndexOfPosition('E', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('F', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('K', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('S', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'E':
			if (pieces[getIndexOfPosition('D', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('F', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('K', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('S', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'F':
			if (pieces[getIndexOfPosition('D', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('E', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('N', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('U', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'G':
			if (pieces[getIndexOfPosition('H', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('I', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('L', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('P', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'H':
			if (pieces[getIndexOfPosition('G', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('I', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('B', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('E', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'I':
			if (pieces[getIndexOfPosition('G', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('H', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('M', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('R', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'J':
			if (pieces[getIndexOfPosition('A', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('V', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('K', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('L', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'K':
			if (pieces[getIndexOfPosition('D', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('S', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('J', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('L', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'L':
			if (pieces[getIndexOfPosition('G', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('P', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('J', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('K', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'M':
			if (pieces[getIndexOfPosition('I', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('R', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('N', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('O', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'N':
			if (pieces[getIndexOfPosition('F', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('U', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('M', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('O', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'O':
			if (pieces[getIndexOfPosition('C', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('X', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('M', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('N', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'P':
			if (pieces[getIndexOfPosition('G', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('L', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('Q', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('R', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'Q':
			if (pieces[getIndexOfPosition('P', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('R', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('T', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('W', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'R':
			if (pieces[getIndexOfPosition('P', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('Q', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('I', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('M', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'S':
			if (pieces[getIndexOfPosition('D', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('K', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('T', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('U', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'T':
			if (pieces[getIndexOfPosition('S', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('U', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('Q', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('W', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'U':
			if (pieces[getIndexOfPosition('F', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('N', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('S', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('T', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'V':
			if (pieces[getIndexOfPosition('A', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('J', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('W', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('X', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'W':
			if (pieces[getIndexOfPosition('V', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('X', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('Q', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('T', fields)] == currentPlayer) {
				mill++;
			}
			break;
		case 'X':
			if (pieces[getIndexOfPosition('V', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('W', fields)] == currentPlayer) {
				mill++;
			}
			if (pieces[getIndexOfPosition('C', fields)] == currentPlayer
					&& pieces[getIndexOfPosition('O', fields)] == currentPlayer) {
				mill++;
			}
			break;
		}
		return mill;
	}

	static char getPositionFromUserPlacingPieces(String message, char[] pieces, char[] fields) {
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

	static boolean isEveryEnemyPieceInMill(char[] pieces, char currentEnemyPlayer, char[] fields) {
		boolean result = true;
		for (int i = 0; i < pieces.length; i++) {
			if (pieces[i] == currentEnemyPlayer) {
				if (isNextToRemoveInMill(fields[i], fields, currentEnemyPlayer, pieces) == false) {
					result = false;
					break;
				}
			}
		}
		return result;
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
			position = scanner.nextLine().toUpperCase();
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
		Scanner in = new Scanner(new File("board.txt"));
		char[][] board = new char[13][25];
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

	static void printBoard(int[][] coordinates, char[] coin, char[][] initialBoard) {
		char[][] board = new char[13][25];
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[row].length; column++) {
				board[row][column] = initialBoard[row][column];
			}
		}
		for (int i = 0; i < coin.length; i++) {
			if (coin[i] != ' ') {
				int row = coordinates[0][i];
				int column = coordinates[1][i];
				board[row][column] = coin[i];
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
