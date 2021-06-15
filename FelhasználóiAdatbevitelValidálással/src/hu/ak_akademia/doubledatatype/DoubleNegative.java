package hu.ak_akademia.doubledatatype;

public class DoubleNegative implements DoubleDataTypeValidable {

	@Override
	public boolean isValid(double number) {
		return number < 0;
	}

}
