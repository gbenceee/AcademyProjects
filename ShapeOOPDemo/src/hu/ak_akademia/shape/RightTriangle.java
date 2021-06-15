package hu.ak_akademia.shape;

public class RightTriangle extends ValidatedShape {

	private double a;
	private double b;
	private double c;

	public RightTriangle(double a, double b) {
		validate(a, "Az a befogó hossza csak pozitív valós szám lehet. a: " + a);
		this.a = a;
		validate(b, "A b befogó hossza csak pozitív valós szám lehet. b: " + b);
		this.b = b;
		c = Math.sqrt(a * a + b * b);
	}

	@Override
	public double calculatePerimeter() {
		return a + b + c;
	}

	@Override
	public double calculateArea() {
		return a * b / 2.0;
	}

}