package hu.ak_akademia.integerdatatype;

public class IntegerLowerThanGivenNumber implements IntegerDataTypeValidable {
	private int givenNumber;

	public IntegerLowerThanGivenNumber(int givenNumber) {
		this.givenNumber = givenNumber;
	}

	@Override
	public boolean isValid(int number) {
		return number < givenNumber;
	}

}
