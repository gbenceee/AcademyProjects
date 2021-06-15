package hu.ak_akademia.shape;

public class PerimeterAndAreaCalculator {

	public static void main(String[] args) {
		Shape shapeToCalculate;

		shapeToCalculate = new Square(5.0);
		System.out.println("Négyzet kerülete: " + shapeToCalculate.calculatePerimeter());
		System.out.println("Négyzet területe: " + shapeToCalculate.calculateArea());
		// ((Square) shapeToCalculate).draw(); // <-- nem javasolt

		shapeToCalculate = new Rectangle(10.0, 20.0);
		System.out.println("Téglalap kerülete: " + shapeToCalculate.calculatePerimeter());
		System.out.println("Téglalap területe: " + shapeToCalculate.calculateArea());

		try {
			shapeToCalculate = new Square(-1.0);
			System.out.println("Négyzet kerülete: " + shapeToCalculate.calculatePerimeter());
			System.out.println("Négyzet területe: " + shapeToCalculate.calculateArea());
		} catch (IllegalArgumentException e) {
			System.out.println("Hiba az alakzat létrehozása közben. Hiba üzenet: " + e.getMessage());
		}
	}

}