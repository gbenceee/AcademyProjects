package hu.ak_akademia.shape;

/**
 * Instances of this class represent a trapezoid with the same leg lengths.
 *
 * @author András Markos
 */
public class Trapezoid extends ValidatedShape {

	private double a;
	private double b;
	private double c;
	private double m;

	/**
	 * Full constructor to create a Trapezoid.
	 *
	 * @param a The length of the top side.
	 * @param b The length of the legs.
	 * @param c T he length of the bottom side.
	 */
	public Trapezoid(double a, double b, double c) {
		validate(a, "Az a oldal hossza csak pozitív valós szám lehet. a: " + a);
		this.a = a;
		validate(b, "A b oldal hossza csak pozitív valós szám lehet. b: " + b);
		this.b = b;
		validate(c, "A c oldal hossza csak pozitív valós szám lehet. c: " + c);
		this.c = c;
		Validator trapezoidValidator = new TrapezoidValidator(a, b, c);
		if (!trapezoidValidator.isValid()) {
			throw new IllegalArgumentException("A megadott oldalhosszakkal nem szerkeszthető trapéz.");
		}
		m = Math.sqrt(b * b - Math.pow((c - a) / 2.0, 2.0));
	}

	@Override
	public double calculatePerimeter() {
		return a + 2.0 * b + c;
	}

	@Override
	public double calculateArea() {
		return (a + c) * m / 2.0;
	}

	// static inner class
	// statikus beágyazott osztály
	private static class TrapezoidValidator implements Validator {

		private double a;
		private double b;
		private double c;

		public TrapezoidValidator(double a, double b, double c) {
			this.a = Math.min(a, c);
			this.b = b;
			this.c = Math.max(a, c);
		}

		@Override
		public boolean isValid() {
			return 2 * b + a > c;
		}

	}

}