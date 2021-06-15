import java.util.Scanner;

public class AmőbaJátékFiveInARow {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Kérlek, add meg hogy a tábla szélessége hány mező legyen.");
		int length = scan.nextInt();
		System.out.println("Kérlek, add meg hogy a tábla magassága hány mező legyen.");
		int height = scan.nextInt();
		// tömb feltöltése szóközökkel
		String[][] table = new String[length][height];
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				table[i][j] = " ";
			}

		}
		// tömb feltöltése "X"-el és "O"-val
		table[0][0] = "X";
		table[1][1] = "X";
		table[0][1] = "O";
		table[1][0] = "O";
		printTable(table);
	}

	private static void printTable(String[][] table) {
		int lengthOfTable = table.length;
		int heightOfTable = table[0].length;
		if (lengthOfTable == 1) {
			lengthOfTable = 7;
		} else {
			lengthOfTable = ((lengthOfTable - 1) * 4) + 7;
		}

		if (heightOfTable == 1) {
			heightOfTable = 3;
		} else {
			heightOfTable = ((heightOfTable - 1) * 2) + 3;
		}

		String[][] display = new String[heightOfTable][lengthOfTable];

		// tömb összes elemét szóközre állítjuk
		/*for (int row = 0; row < display.length; row++) {
			for (int column = 0; column < display[row].length; column++) {
				display[row][column] = " ";
			}
		}*/
		// négyzetrács rajzolása
		for (int row = 0; row < display.length; row++) {
			for (int column = 0; column < display[row].length; column++) {
				if (row % 2 != 0 && column % 4 == 3) {
					display[row][column] = "┼";
				} else if (row % 2 != 0) {
					display[row][column] = "─";
				} else if (column % 4 == 3) {
					display[row][column] = "│";
				} else {
					display[row][column] = " ";
				}
			}
		}
		// tömb feltöltése "X"-el és "O"-val a bemeneti paraméter alapján
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				if (table[i][j] != " ") {
					display[((i + 1) * 2)][(j * 4) + 5] = table[i][j];
				}
			}
		}
		// oszlopok és sorok számozása
		int numberOfColumn = 1;
		int numberOfRow = 1;
		for (int row = 0; row < display.length; row++) {
			for (int column = 0; column < display[row].length; column++) {
				// oszlopok számozása
				if (row == 0 && column > 4 && column % 4 == 1) {
					// ha az oszlop számozása 3 számjegyű
					if (numberOfColumn >= 100) {
						String columnNumber = String.valueOf(numberOfColumn);
						char firstDigitOfColumnNumber = columnNumber.charAt(0);
						char secondDigitOfColumnNumber = columnNumber.charAt(1);
						char thirdDigitOfColumnNumber = columnNumber.charAt(2);
						columnNumber = Character.toString(firstDigitOfColumnNumber);
						display[row][column - 1] = columnNumber;
						columnNumber = Character.toString(secondDigitOfColumnNumber);
						display[row][column] = columnNumber;
						columnNumber = Character.toString(thirdDigitOfColumnNumber);
						display[row][column + 1] = columnNumber;
						numberOfColumn++;
						// ha az oszlop számozása 2 számjegyű
					} else if (numberOfColumn >= 10) {
						String columnNumber = String.valueOf(numberOfColumn);
						char firstDigitOfColumnNumber = columnNumber.charAt(0);
						char secondDigitOfColumnNumber = columnNumber.charAt(1);
						columnNumber = Character.toString(firstDigitOfColumnNumber);
						display[row][column - 1] = columnNumber;
						columnNumber = Character.toString(secondDigitOfColumnNumber);
						display[row][column] = columnNumber;
						numberOfColumn++;

					} else {
						String columnNumber = String.valueOf(numberOfColumn);
						display[row][column] = columnNumber;
						numberOfColumn++;
					}
				}
				// sorok számozása
				if (column == 1 && row > 1 && row % 2 == 0) {
					// ha a sor számozása 3 számjegyű
					if (numberOfRow >= 100) {
						String rowNumber = String.valueOf(numberOfRow);
						char firstDigitOfRowNumber = rowNumber.charAt(0);
						char secondDigitOfRowNumber = rowNumber.charAt(1);
						char thirdDigitOfRowNumber = rowNumber.charAt(2);
						rowNumber = Character.toString(firstDigitOfRowNumber);
						display[row][column - 1] = rowNumber;
						rowNumber = Character.toString(secondDigitOfRowNumber);
						display[row][column] = rowNumber;
						rowNumber = Character.toString(thirdDigitOfRowNumber);
						display[row][column + 1] = rowNumber;
						numberOfRow++;
						// ha a sor számozása 2 számjegyű
					} else if (numberOfRow >= 10) {
						String rowNumber = String.valueOf(numberOfRow);
						char firstDigitOfRowNumber = rowNumber.charAt(0);
						char secondDigitOfRowNumber = rowNumber.charAt(1);
						rowNumber = Character.toString(firstDigitOfRowNumber);
						display[row][column - 1] = rowNumber;
						rowNumber = Character.toString(secondDigitOfRowNumber);
						display[row][column ] = rowNumber;
						numberOfRow++;
					} else {
						String rowNumber = String.valueOf(numberOfRow);
						display[row][column] = rowNumber;
						numberOfRow++;
					}
				}
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
