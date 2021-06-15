package hu.ak_akademia.stringdatatype;

public class StringContainsAtLeastTheGivenCharacters implements StringDataTypeValidable {
	private char[] specifiedCharacters;

	public StringContainsAtLeastTheGivenCharacters(char... specifiedCharacters) {
		this.specifiedCharacters = specifiedCharacters;
	}

	@Override
	public boolean isValid(String inputFromUser) {
		loop: for (int i = 0; i < specifiedCharacters.length; i++) {
			for (int j = 0; j < inputFromUser.length(); j++) {
				if (specifiedCharacters[i] == inputFromUser.charAt(j)) {
					continue loop;
				}
			}
			return false;
		}
		return true;
	}

}
