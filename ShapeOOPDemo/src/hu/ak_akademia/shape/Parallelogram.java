package hu.ak_akademia.shape;

public class Parallelogram extends ValidatedShape {

	private double a;
	private double b;
	private double m;

	public Parallelogram(double a, double b, double m) {
		validate(a, "Az a oldal hossza csak pozitív valós szám lehet. a: " + a);
		this.a = a;
		validate(b, "A b oldal hossza csak pozitív valós szám lehet. b: " + b);
		this.b = b;
		validate(m, "Az m magasság hossza csak pozitív valós szám lehet. m: " + m);
		this.m = m;
	}

	@Override
	public double calculatePerimeter() {
		return 2 * (a + b);
	}

	@Override
	public double calculateArea() {
		return b * m;
	}

}