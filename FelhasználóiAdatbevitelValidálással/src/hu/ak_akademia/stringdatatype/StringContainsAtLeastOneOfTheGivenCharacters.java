package hu.ak_akademia.stringdatatype;

public class StringContainsAtLeastOneOfTheGivenCharacters implements StringDataTypeValidable {
	private char[] specifiedCharacters;

	public StringContainsAtLeastOneOfTheGivenCharacters(char... specifiedCharacters) {
		this.specifiedCharacters = specifiedCharacters;
	}

	@Override
	public boolean isValid(String inputFromUser) {
		for (int i = 0; i < specifiedCharacters.length; i++) {
			for (int j = 0; j < inputFromUser.length(); j++) {
				if (inputFromUser.charAt(j) == specifiedCharacters[i]) {
					return true;
				}
			}
		}
		return false;
	}

}
