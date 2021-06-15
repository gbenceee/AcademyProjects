package hu.ak_akademia.integerdatatype;

public class IntegerPrime implements IntegerDataTypeValidable {

	@Override
	public boolean isValid(int number) {
		if (number == 1) {
			return false;
		} else if (number == 2) {
			return true;
		} else {
			for (int i = 2; i <= Math.sqrt(number); i++) {
				if (number % i == 0) {
					return false;
				}
			}
		}
		return true;
	}

}
