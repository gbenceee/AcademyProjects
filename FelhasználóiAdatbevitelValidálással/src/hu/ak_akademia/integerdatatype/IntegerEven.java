package hu.ak_akademia.integerdatatype;

public class IntegerEven implements IntegerDataTypeValidable {

	@Override
	public boolean isValid(int number) {
		return number % 2 == 0;
	}

}
