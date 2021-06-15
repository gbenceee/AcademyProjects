package hu.ak_akademia.stringdatatype;

public class StringLengthWithinBounds implements StringDataTypeValidable {

	@Override
	public boolean isValid(String inputFromUser) {
		return inputFromUser.length() <= 20 && inputFromUser.length() >= 5;
	}

}
