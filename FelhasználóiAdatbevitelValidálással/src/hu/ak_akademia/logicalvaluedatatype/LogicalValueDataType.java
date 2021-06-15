package hu.ak_akademia.logicalvaluedatatype;

public class LogicalValueDataType implements LogicalValueValidable {

	@Override
	public boolean isValid(String inputFromUser) {
		return inputFromUser.equalsIgnoreCase("i") || inputFromUser.equalsIgnoreCase("igaz") || inputFromUser.equalsIgnoreCase("true") || inputFromUser.equalsIgnoreCase("h")
				|| inputFromUser.equalsIgnoreCase("hamis") | inputFromUser.equalsIgnoreCase("false");
	}

}
