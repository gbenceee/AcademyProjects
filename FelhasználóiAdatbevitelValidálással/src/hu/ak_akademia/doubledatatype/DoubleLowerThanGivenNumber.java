package hu.ak_akademia.doubledatatype;

public class DoubleLowerThanGivenNumber implements DoubleDataTypeValidable {
	private double givenNumber;

	public DoubleLowerThanGivenNumber(double givenNumber) {
		this.givenNumber = givenNumber;
	}

	@Override
	public boolean isValid(double number) {
		return number < givenNumber;
	}

}
