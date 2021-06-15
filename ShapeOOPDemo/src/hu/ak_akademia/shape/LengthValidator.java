package hu.ak_akademia.shape;

public class LengthValidator implements Validator {

	private double sideLength;

	public LengthValidator(double sideLength) {
		this.sideLength = sideLength;
	}

	@Override
	public boolean isValid() {
		return sideLength > 0.0;
	}

}