package hu.ak_akademia.uservalidation;

public class OddIntegerValidator implements IntegerValidator {

	@Override
	public boolean isValid(int number) {
		return number % 2 != 0;
	}

}
