package hu.ak_akademia.shape;

public class Rhombus extends ValidatedShape {

	private double a;
	private double e;
	private double f;

	public Rhombus(double e, double f) {
		validate(e, "Az e átló hossza csak pozitív valós szám lehet. e: " + e);
		this.e = e;
		validate(f, "Az f átló hossza csak pozitív valós szám lehet. f: " + f);
		this.f = f;
		a = Math.sqrt(Math.pow(e / 2, 2) + Math.pow(f / 2, 2));
	}

	@Override
	public double calculatePerimeter() {
		return 4 * a;
	}

	@Override
	public double calculateArea() {
		return e * f / 2;
	}

}