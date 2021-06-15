package hu.ak_akademia.uservalidation;

public class LessThanIntegerValidator implements IntegerValidator {

	private int limit;

	public LessThanIntegerValidator(int limit) {
		this.limit = limit;
	}

	@Override
	public boolean isValid(int number) {
		return number < limit;
	}

}
