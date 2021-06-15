package hu.ak_akademia.uservalidation;

public class GreaterThanIntegerValidator implements IntegerValidator {

	private int limit;

	public GreaterThanIntegerValidator(int limit) {
		this.limit = limit;
	}

	@Override
	public boolean isValid(int number) {
		return number > limit;
	}

	public void otherCalculation() {

	}

}
