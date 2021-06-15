package hu.ak_akademia.stringdatatype;

public class StringContainsOnlyTheSpecifiedCharacters implements StringDataTypeValidable {
	private char[] specifiedCharacters;

	public StringContainsOnlyTheSpecifiedCharacters(char... specifiedCharacters) {
		this.specifiedCharacters = specifiedCharacters;
	}

	@Override
	public boolean isValid(String inputFromUser) {
		String s = String.copyValueOf(specifiedCharacters);
		return inputFromUser.contentEquals(s);
	}

}
