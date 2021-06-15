package hu.ak_akademia.integerdatatype;

public class IntegerNegative implements IntegerDataTypeValidable {

	@Override
	public boolean isValid(int number) {
		return number < 0;
	}

}
