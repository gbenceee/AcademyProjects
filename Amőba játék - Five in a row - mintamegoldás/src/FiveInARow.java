import java.util.Scanner;

public class FiveInARow {

	public static void main(String[] args) {
		int size = scanSizeFromUser("Kérem adja meg a tábla méretét: ");
		String[][] table = new String[size][size];
		// tömb összes elemét szóközre állítjuk
		clearTable(table);
		// standard kimeneten megjelenítjük az akutális játékállást
		printTable(table);
		int counter = 0;
		String currentPlayer;
		int[] field;
		do {
			currentPlayer = ++counter % 2 == 0 ? "O" : "X";
			field = makeNextMove(table, currentPlayer);
			printTable(table);
		} while (!isGameOver(field, table, counter));
		if (isGameWon(field, table)) {
			System.out.println("Gratulálok a győztes " + currentPlayer);
		} else if (isSimpleDraw(counter, table) || isComplexDraw(table)) {
			System.out.println("Döntetlen!");
		}
	}

	static boolean isFiveInARowHorizontally(int[] field, String[][] table) {
		int numberOfSignsToTheLeft = isFiveInARow(field, table, -1, 0);
		int numberOfSignsToTheRight = isFiveInARow(field, table, 1, 0);
		int numbersOfSignsAllTogether = numberOfSignsToTheLeft + numberOfSignsToTheRight + 1;
		return numbersOfSignsAllTogether >= 5;
	}

	static boolean isFiveInARowVertically(int[] field, String[][] table) {
		int numberOfSignsToTheTop = isFiveInARow(field, table, 0, -1);
		int numberOfSignsToTheBottom = isFiveInARow(field, table, 0, 1);
		int numbersOfSignsAllTogether = numberOfSignsToTheTop + numberOfSignsToTheBottom + 1;
		return numbersOfSignsAllTogether >= 5;
	}

	static boolean isFiveInARowSlash(int[] field, String[][] table) {
		int numberOfSignsToTheTopRight = isFiveInARow(field, table, -1, 1);
		int numberOfSignsToTheBottomLeft = isFiveInARow(field, table, 1, -1);
		int numbersOfSignsAllTogether = numberOfSignsToTheTopRight + numberOfSignsToTheBottomLeft + 1;
		return numbersOfSignsAllTogether >= 5;
	}

	static boolean isFiveInARowBackSlash(int[] field, String[][] table) {
		int numberOfSignsToTheTopLeft = isFiveInARow(field, table, -1, -1);
		int numberOfSignsToTheBottomRight = isFiveInARow(field, table, 1, 1);
		int numbersOfSignsAllTogether = numberOfSignsToTheTopLeft + numberOfSignsToTheBottomRight + 1;
		return numbersOfSignsAllTogether >= 5;
	}

	static int isFiveInARow(int[] field, String[][] table, int horizontal, int vertical) {
		int counter = 0;
		final int row = field[0];
		final int column = field[1];
		int currentRow = row;
		int currentColumn = column;
		String signToCheck = table[row][column];
		while (counter < 5) {
			currentRow += vertical;
			currentColumn += horizontal;
			if (isFieldWithinBounds(currentRow, currentColumn, table) && table[currentRow][currentColumn].equals(signToCheck)) {
				counter++;
			} else {
				break;
			}
		}
		return counter;
	}

	static boolean isGameOver(int[] field, String[][] table, int counter) {
		return isSimpleDraw(counter, table) || isComplexDraw(table) || isGameWon(field, table);
	}

	static boolean isGameWon(int[] field, String[][] table) {
		return isFiveInARowHorizontally(field, table) || isFiveInARowVertically(field, table) || isFiveInARowSlash(field, table) || isFiveInARowBackSlash(field, table);
	}

	static boolean isSimpleDraw(int counter, String[][] table) {
		if (counter >= Math.pow(table.length, 2)) {
			return true;
		}
		return false;
	}

	static boolean isComplexDraw(String[][] table) {
		return isDrawPossible(makeDrawTable(table, "X"), "X") && isDrawPossible(makeDrawTable(table, "O"), "O");
		// String[][] drawCheckX = makeDrawTable(table, "X");
		// if (!isDrawPossible(drawCheckX, "X")) {
		// return false;
		// }
		// String[][] drawCheckO = makeDrawTable(table, "O");
		// if (!isDrawPossible(drawCheckO, "O")) {
		// return false;
		// }
		//
		// return true;
	}

	static boolean isDrawPossible(String[][] drawCheck, String signToCheck) {
		for (int row = 0; row < drawCheck.length; row++) {
			for (int column = 0; column < drawCheck[row].length; column++) {
				if (drawCheck[row][column].equals(signToCheck)) {
					int[] field = { row, column };
					if (isGameWon(field, drawCheck)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	static String[][] makeDrawTable(String[][] table, String signToFill) {
		String[][] drawCheck = new String[table.length][table.length];
		/*
		 * for (String[] column : table) { for (String cell : column) {
		 * 
		 * } }
		 */
		for (int row = 0; row < table.length; row++) {
			for (int column = 0; column < table[row].length; column++) {
				if (table[row][column].equals(" ")) {
					drawCheck[row][column] = signToFill;
				} else {
					drawCheck[row][column] = table[row][column];
				}
			}
		}
		return drawCheck;
	}

	static int[] makeNextMove(String[][] table, String currentPlayer) {
		System.out.println("Most az " + currentPlayer + " játékos következik.");
		int[] field = scanFieldFromUser(table);
		int row = field[0];
		int column = field[1];
		table[row][column] = currentPlayer;
		return field;
	}

	static int[] scanFieldFromUser(String[][] table) {
		int row = 0;
		int column = 0;
		do {
			row = scanNumberFromUser("Kérem adja meg a sorszámot: ");
			row--;
			column = scanNumberFromUser("Kérem adja meg az oszlopszámot: ");
			column--;
			if (!isFieldCorrect(row, column, table)) {
				System.out.println("Helytelen mező!");
			}
		} while (!isFieldCorrect(row, column, table));
		return new int[] { row, column };
	}

	static void clearTable(String[][] table) {
		for (int row = 0; row < table.length; row++) {
			for (int column = 0; column < table[row].length; column++) {
				table[row][column] = " ";
			}
		}
	}

	static int scanSizeFromUser(String message) {
		int size = 0;
		do {
			size = scanNumberFromUser(message);
			if (!isTableSizeCorrect(size)) {
				System.out.println("A méret csak 5 és 20 között lehet.");
			}
		} while (!isTableSizeCorrect(size));
		return size;
	}

	static int scanNumberFromUser(String message) {
		Scanner in = new Scanner(System.in);
		System.out.print(message);
		int number = in.nextInt();
		in.nextLine();
		return number;
	}

	static boolean isTableSizeCorrect(int size) {
		return size <= 20 && size >= 5;
	}

	static boolean isFieldCorrect(int row, int column, String[][] table) {
		return isFieldWithinBounds(row, column, table) && isFieldEmpty(row, column, table);
	}

	static boolean isFieldEmpty(int row, int column, String[][] table) {
		return table[row][column].equals(" ");
	}

	static boolean isFieldWithinBounds(int row, int column, String[][] table) {
		return row >= 0 && row < table.length && column >= 0 && column < table.length;
	}

	static void printTable(String[][] table) {
		int height = 2 * table.length + 3;
		int width = 4 * table.length + 5;
		String[][] display = new String[height][width];

		// négyzetrács rajzolása
		int lastColumn = display[height - 1].length - 1;
		int lastRow = display.length - 1;

		for (int row = 0; row < display.length; row++) {
			for (int column = 0; column < display[row].length; column++) {
				if (row == 0 && column == 0) {
					display[row][column] = "┌";
				} else if (row == 0 && column == lastColumn) {
					display[row][column] = "┐";
				} else if (row == lastRow && column == 0) {
					display[row][column] = "└";
				} else if (row == lastRow && column == lastColumn) {
					display[row][column] = "┘";
				} else if (row == 0 && column % 4 == 0) {
					display[row][column] = "┬";
				} else if (row % 2 == 0 && column == 0) {
					display[row][column] = "├";
				} else if (row % 2 == 0 && column == lastColumn) {
					display[row][column] = "┤";
				} else if (row == lastRow && column % 4 == 0) {
					display[row][column] = "┴";
				} else if (row % 2 == 0 && column % 4 == 0) {
					display[row][column] = "┼";
				} else if (row % 2 == 0) {
					display[row][column] = "─";
				} else if (column % 4 == 0) {
					display[row][column] = "│";
				} else {
					display[row][column] = " ";
				}
			}
		}

		for (int i = 1; i <= table.length; i++) {
			if (i < 10) {
				display[i * 2 + 1][2] = Integer.toString(i);
				display[1][i * 4 + 2] = Integer.toString(i);
			} else {
				int tens = i / 10;
				int ones = i % 10;
				display[i * 2 + 1][1] = Integer.toString(tens);
				display[i * 2 + 1][2] = Integer.toString(ones);
				display[1][i * 4 + 1] = Integer.toString(tens);
				display[1][i * 4 + 2] = Integer.toString(ones);
			}
		}

		for (int row = 0; row < table.length; row++) {
			for (int column = 0; column < table[row].length; column++) {
				display[row * 2 + 3][column * 4 + 6] = table[row][column];
			}
		}

		// tömb megjelenítése a standard kimeneten
		for (int row = 0; row < display.length; row++) {
			for (int column = 0; column < display[row].length; column++) {
				System.out.print(display[row][column]);
			}
			System.out.println();
		}
	}

}