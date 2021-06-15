
public class Verify {
	public boolean isEven(long number) {
		if (number % 2 == 0)
			return true;

		return false;
	}

	public long generateSequenceNumber(long number) {
		if (isEven(number)) {
			return number / 2;
		} else if (!isEven(number) && number != 1) {
			return number * 3 + 1;
		}

		return 1;
	}
}
