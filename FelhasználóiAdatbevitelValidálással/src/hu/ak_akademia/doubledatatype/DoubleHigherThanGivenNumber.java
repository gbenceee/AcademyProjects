package hu.ak_akademia.doubledatatype;

public class DoubleHigherThanGivenNumber implements DoubleDataTypeValidable {
	private double givenNumber;

	public DoubleHigherThanGivenNumber(double givenNumber) {
		this.givenNumber = givenNumber;
	}

	@Override
	public boolean isValid(double number) {
		return number > givenNumber;
	}

}
