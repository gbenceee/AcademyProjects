package hu.ak_akademia.stringdatatype;

public class StringNotEmpty implements StringDataTypeValidable {

	@Override
	public boolean isValid(String inputFromUser) {
		return inputFromUser.length() > 0;
	}

}
