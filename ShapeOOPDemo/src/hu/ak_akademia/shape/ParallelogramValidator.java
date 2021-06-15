package hu.ak_akademia.shape;

public class ParallelogramValidator implements Validator {

	private double a;
	private double m;

	public ParallelogramValidator(double a, double m) {
		this.a = a;
		this.m = m;
	}

	@Override
	public boolean isValid() {
		return Double.compare(m, a) <= 0;
	}

}