public class PrintGeometricShapes {

	public static void main(String[] args) {
		drawRectangle(10, 5, true);
		System.out.println("-----------------");
		drawRectangle(10, 5, false);
		System.out.println("-----------------");
		drawSquare(5, true);
		System.out.println("-----------------");
		drawSquare(5, false);
		System.out.println("-----------------");
		drawRhombus(7, true);
		System.out.println("-----------------");
		drawRhombus(7, false);
	}

	static void drawRectangle(int width, int height, boolean filled) {
		for (int row = 1; row <= height; row++) {
			for (int column = 1; column <= width; column++) {
				if (filled || row == 1 || row == height || column == 1 || column == width) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	static void drawSquare(int size, boolean filled) {
		drawRectangle(size, size, filled);
	}

	static void drawRhombus(int size, boolean filled) {
		int numberOfSpaces = size / 2;
		int numberOfAsterisks = 1;
		for (int row = 1; row <= size; row++) {
			printSpaces(numberOfSpaces);
			printAsterisks(numberOfAsterisks, filled);
			printNewLine();
			if (row <= size / 2) {
				numberOfSpaces--;
				numberOfAsterisks += 2;
			} else {
				numberOfSpaces++;
				numberOfAsterisks -= 2;
			}
		}
	}

	static void printSpaces(int amount) {
		print(" ", amount);
	}

	static void printAsterisks(int amount, boolean filled) {
		if (filled) {
			print("*", amount);
		} else {
			if (amount > 2) {
				print("*", 1);
				print(" ", amount - 2);
				print("*", 1);
			} else {
				print("*", amount);
			}
		}
	}

	static void print(String character, int amount) {
		for (int i = 0; i < amount; i++) {
			System.out.print(character);
		}
	}

	static void printNewLine() {
		System.out.println();
	}

}