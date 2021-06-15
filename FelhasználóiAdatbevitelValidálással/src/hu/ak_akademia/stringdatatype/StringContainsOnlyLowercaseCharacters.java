package hu.ak_akademia.stringdatatype;

public class StringContainsOnlyLowercaseCharacters implements StringDataTypeValidable {

	@Override
	public boolean isValid(String inputFromUser) {
		for (int i = 0; i < inputFromUser.length(); i++) {
			if (!Character.isLowerCase(inputFromUser.charAt(i))) {
				return false;
			}
		}
		return true;
	}

}
