package hu.ak_akademia.integerdatatype;

public class IntegerInGivenNumbers implements IntegerDataTypeValidable {
	private int[] numbers;

	public IntegerInGivenNumbers(int[] numbers) {
		this.numbers = numbers;
	}

	@Override
	public boolean isValid(int number) {
		for (int i : numbers) {
			if (i == number)
				return true;
		}
		return false;
	}

}
