package hu.ak_akademia.stringdatatype;

public class StringContainsTheSpecifiedCharacters implements StringDataTypeValidable {
	private char[] specifiedCharacters;

	public StringContainsTheSpecifiedCharacters(char... specifiedCharacters) {
		this.specifiedCharacters = specifiedCharacters;
	}

	@Override
	public boolean isValid(String inputFromUser) {
		for (int i = 0; i < inputFromUser.length(); i++) {
			for (int j = 0; j < specifiedCharacters.length; j++) {
				if (specifiedCharacters[j] == inputFromUser.charAt(i)) {
					return true;
				}
			}
		}
		return false;
	}

}
