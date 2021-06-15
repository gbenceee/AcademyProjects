package hu.ak_akademia.integerdatatype;

public class IntegerWithinBounds implements IntegerDataTypeValidable {
	private int highestNumber;
	private int lowestNumber;

	public IntegerWithinBounds(int highestNumber, int lowestNumber) {
		this.highestNumber = highestNumber;
		this.lowestNumber = lowestNumber;
	}

	@Override
	public boolean isValid(int number) {
		return number <= highestNumber && number >= lowestNumber;
	}

}
