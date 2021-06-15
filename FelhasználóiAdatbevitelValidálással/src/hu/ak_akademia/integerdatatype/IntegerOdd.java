package hu.ak_akademia.integerdatatype;

public class IntegerOdd implements IntegerDataTypeValidable {

	@Override
	public boolean isValid(int number) {
		return number % 2 != 0;
	}

}
