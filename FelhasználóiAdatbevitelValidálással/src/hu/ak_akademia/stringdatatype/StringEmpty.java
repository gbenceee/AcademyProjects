package hu.ak_akademia.stringdatatype;

public class StringEmpty implements StringDataTypeValidable {

	@Override
	public boolean isValid(String inputFromUser) {
		return inputFromUser.length() == 0;
	}

}
