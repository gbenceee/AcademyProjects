package hu.ak_akademia.shape;

public class TrapezoidValidator implements Validator {

	private double a;
	private double b;
	private double c;
	private double m;

	public TrapezoidValidator(double a, double b, double c) {
		if (!new LengthValidator(a).isValid()) {
			throw new IllegalArgumentException("Az a oldal hossza csak pozitív valós szám lehet. a: " + a);
		}
		this.a = Math.min(a, c);
		if (!new LengthValidator(b).isValid()) {
			throw new IllegalArgumentException("Az b oldal hossza csak pozitív valós szám lehet. b: " + b);
		}
		this.b = b;
		if (!new LengthValidator(c).isValid()) {
			throw new IllegalArgumentException("Az a oldal hossza csak pozitív valós szám lehet. c: " + c);
		}
		this.c = Math.max(a, c);
		Validator trapeValidator = new TrapezoidValidator(a, b, c);
		if (!trapeValidator.isValid()) {
			throw new IllegalArgumentException("");

		}
		m = Math.sqrt(b * b - (Math.pow((c - a) / 2.0, 2.0)));
	}

	@Override
	public boolean isValid() {
		return 2 * b + a > c;
	}

}
