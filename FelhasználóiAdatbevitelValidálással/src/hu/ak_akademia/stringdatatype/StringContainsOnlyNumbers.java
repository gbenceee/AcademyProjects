package hu.ak_akademia.stringdatatype;

import java.util.regex.Pattern;

public class StringContainsOnlyNumbers implements StringDataTypeValidable {

	@Override
	public boolean isValid(String inputFromUser) {
		return Pattern.matches("^\\d+$", inputFromUser);
	}

}
