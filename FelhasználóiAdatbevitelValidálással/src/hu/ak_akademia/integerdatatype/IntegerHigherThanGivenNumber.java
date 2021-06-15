package hu.ak_akademia.integerdatatype;

public class IntegerHigherThanGivenNumber implements IntegerDataTypeValidable {
	private int givenNumber;

	public IntegerHigherThanGivenNumber(int givenNumber) {
		this.givenNumber = givenNumber;
	}

	@Override
	public boolean isValid(int number) {
		return number > givenNumber;
	}

}
