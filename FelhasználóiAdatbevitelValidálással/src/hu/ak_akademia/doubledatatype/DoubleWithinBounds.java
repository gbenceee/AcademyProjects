package hu.ak_akademia.doubledatatype;

public class DoubleWithinBounds implements DoubleDataTypeValidable {
	private double lowestNumber;
	private double highestNumber;

	public DoubleWithinBounds(double lowestNumber, double highestNumber) {
		this.lowestNumber = lowestNumber;
		this.highestNumber = highestNumber;
	}

	@Override
	public boolean isValid(double number) {
		return number <= highestNumber && number >= lowestNumber;
	}

}
