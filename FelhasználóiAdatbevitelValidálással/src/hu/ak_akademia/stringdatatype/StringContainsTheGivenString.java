package hu.ak_akademia.stringdatatype;

public class StringContainsTheGivenString implements StringDataTypeValidable {
	private String givenString;

	public StringContainsTheGivenString(String givenString) {
		this.givenString = givenString;
	}

	@Override
	public boolean isValid(String inputFromUser) {
		return inputFromUser.contains(givenString);
	}

}
