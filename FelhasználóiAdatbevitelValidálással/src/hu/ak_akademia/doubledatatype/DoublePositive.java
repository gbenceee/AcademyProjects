package hu.ak_akademia.doubledatatype;

public class DoublePositive implements DoubleDataTypeValidable {

	@Override
	public boolean isValid(double number) {
		return number > 0;
	}

}
