package hu.ak_akademia.stringdatatype;

public class StringLengthLowerThanGiveLength implements StringDataTypeValidable {
	private int givenLength;

	public StringLengthLowerThanGiveLength(int givenLength) {
		this.givenLength = givenLength;
	}

	@Override
	public boolean isValid(String inputFromUser) {
		return inputFromUser.length() < givenLength;
	}

}
