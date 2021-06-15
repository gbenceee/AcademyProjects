package hu.ak_akademia.stringdatatype;

public class StringLengthHigherThanGiveLength implements StringDataTypeValidable {
	private int givenLength;

	public StringLengthHigherThanGiveLength(int givenLength) {
		this.givenLength = givenLength;
	}

	@Override
	public boolean isValid(String inputFromUser) {
		return inputFromUser.length() > givenLength;
	}

}
