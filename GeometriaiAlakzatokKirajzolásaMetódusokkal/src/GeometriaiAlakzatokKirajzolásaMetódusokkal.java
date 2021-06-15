
public class GeometriaiAlakzatokKirajzolásaMetódusokkal {

	public static void main(String[] args) {
		rhombus(10, true);
		
	}

	static void rectangle(int heightOfRectangle, int widthOfRectangle, boolean filled) {
		if (filled) {
			int heightOfFilledRectangle = heightOfRectangle;
			int widthOfFilledRectangle = widthOfRectangle;
			if (widthOfFilledRectangle == heightOfFilledRectangle) {
				System.out.println("Egy téglalap csak akkor téglalap, ha szélessége és magassága eltérő méretű.");
				return;
			}
			for (int i = 0; i < heightOfFilledRectangle; i++) {
				System.out.println();
				for (int j = 0; j < widthOfFilledRectangle; j++) {
					System.out.print("*");
				}
			}
		} else {
			int widthOfEmptyRectangle = widthOfRectangle;
			int heightOfEmptyRectangle = heightOfRectangle;
			if (widthOfEmptyRectangle == heightOfEmptyRectangle) {
				System.out.println("Egy téglalap csak akkor téglalap, ha szélessége és magassága eltérő mértékű.");
				return;
			}
			for (int i = 0; i < heightOfEmptyRectangle; i++) {
				System.out.println();
				for (int j = 0; j < widthOfEmptyRectangle; j++) {
					if (i == 0) {
						System.out.print("*");
					} else if (i == heightOfEmptyRectangle - 1) {
						System.out.print("*");
					} else if (j == 0 || j == widthOfEmptyRectangle - 1) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}
		}
	}

	static void square(int heightOfSquare, boolean filled) {
		if (filled) {
			int heightOfFilledSquare = heightOfSquare;
			for (int i = 0; i < heightOfFilledSquare; i++) {
				System.out.println();
				for (int j = 0; j < heightOfFilledSquare; j++) {
					System.out.print("*");
				}
			}
		} else {
			int heightOfEmptySquare = heightOfSquare;
			for (int i = 0; i < heightOfEmptySquare; i++) {
				System.out.println();
				for (int j = 0; j < heightOfEmptySquare; j++) {
					if (i == 0) {
						System.out.print("*");
					} else if (i == heightOfEmptySquare - 1) {
						System.out.print("*");
					} else if (j == 0 || j == heightOfEmptySquare - 1) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}
		}
	}
 
	static void rhombus(int heightOfRhombus, boolean filled) {
		if (filled) {
			int heightOfFilledRhombus = heightOfRhombus;
			int edgeModifier = 0;
			for (int i = 0; i < heightOfFilledRhombus / 2; i++) {
				System.out.println();
				for (int j = 0; j < heightOfFilledRhombus; j++) {
					if ((heightOfFilledRhombus / 2) - edgeModifier > j
							|| (heightOfFilledRhombus / 2) + edgeModifier < j) {
						System.out.print(" ");
					} else {
						System.out.print("*");
					}
				}
				edgeModifier++;
			}
			for (int i = 0; i <= heightOfFilledRhombus / 2; i++) {
				System.out.println();
				for (int j = 0; j < heightOfFilledRhombus + 1; j++) {
					if ((heightOfFilledRhombus / 2) - edgeModifier > j
							|| (heightOfFilledRhombus / 2) + edgeModifier < j) {
						System.out.print(" ");
					} else {
						System.out.print("*");
					}
				}
				edgeModifier--;
			}
		} else {
			int heightOfEmptyRhombus = heightOfRhombus;
			int edgeModifier = 0;
			for (int i = 0; i < heightOfEmptyRhombus / 2; i++) {
				System.out.println();
				for (int j = 0; j < heightOfEmptyRhombus; j++) {
					if ((heightOfEmptyRhombus / 2) - edgeModifier == j
							|| (heightOfEmptyRhombus / 2) + edgeModifier == j) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
				edgeModifier++;
			}
			for (int i = 0; i <= heightOfEmptyRhombus / 2; i++) {
				System.out.println();
				for (int j = 0; j < heightOfEmptyRhombus + 1; j++) {
					if ((heightOfEmptyRhombus / 2) - edgeModifier == j
							|| (heightOfEmptyRhombus / 2) + edgeModifier == j) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
				edgeModifier--;
			}
		}
	}

	static void parallelogram(int heightOfParallelogram, int widthOfParallelogram, boolean filled) {
		if (filled) {
			int heightOfFilledParallelogram = heightOfParallelogram;
			int widthOfFilledParallelogram = widthOfParallelogram;
			int widthAndHeight = heightOfFilledParallelogram + widthOfFilledParallelogram;
			int rightEdgeModifier = (heightOfFilledParallelogram + widthOfFilledParallelogram) - 1;
			int leftEdgeModifier = 0;
			for (int i = 0; i < heightOfFilledParallelogram; i++) {
				System.out.println();
				for (int j = 0; j < widthAndHeight; j++) {
					if (j < heightOfFilledParallelogram - leftEdgeModifier || j > rightEdgeModifier) {
						System.out.print(" ");
					} else {
						System.out.print("*");
					}
				}
				leftEdgeModifier++;
				rightEdgeModifier--;
			}
		} else {
			int heightOfEmptyParallelogram = heightOfParallelogram;
			int widthOfEmptyParallelogram = widthOfParallelogram;
			int widthAndHeight = heightOfEmptyParallelogram + widthOfEmptyParallelogram;
			int rightEdgeModifier = widthAndHeight - 1;
			int leftEdgeModifier = 0;
			for (int i = 0; i < heightOfEmptyParallelogram; i++) {
				System.out.println();
				for (int j = 0; j < widthAndHeight; j++) {
					if (i == 0) {
						if (j < heightOfEmptyParallelogram - leftEdgeModifier || j > rightEdgeModifier) {
							System.out.print(" ");
						} else {
							System.out.print("*");
						}
					} else if (i == heightOfEmptyParallelogram - 1) {
						if (j < heightOfEmptyParallelogram - leftEdgeModifier || j > rightEdgeModifier) {
							System.out.print(" ");
						} else {
							System.out.print("*");
						}
					} else if (j == heightOfEmptyParallelogram - leftEdgeModifier || j == rightEdgeModifier) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
				leftEdgeModifier++;
				rightEdgeModifier--;
			}
		}
	}

}
