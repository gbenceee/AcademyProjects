package hu.ak_akademia.uservalidation;

public class EvenIntegerValidator implements IntegerValidator {

	@Override
	public boolean isValid(int number) {
		return number % 2 == 0;
	}

}
