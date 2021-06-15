package hu.ak_akademia.uservalidation;

public class Main {

	public static void main(String[] args) {
		IntegerValidator[] validators = new IntegerValidator[3];
		validators[0] = new EvenIntegerValidator();
		validators[1] = new LessThanIntegerValidator(5);
		validators[2] = new GreaterThanIntegerValidator(5);
		int number = read("Kérem, adjon meg 0 és 10 közötti páros számot: ", validators);
	}

	private static int read(String string, IntegerValidator[] validators) {
		for (IntegerValidator integerValidator : validators) {
			if (integerValidator instanceof GreaterThanIntegerValidator) {
				((GreaterThanIntegerValidator) integerValidator).otherCalculation();
			}
		}
		return 0;
	}

}
