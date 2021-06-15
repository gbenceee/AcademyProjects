package hu.ak_akademia.fizzbuzz;

public class PrintEachNumber extends TextAppender {
	private int number;

	public PrintEachNumber(int number) {
		this.number = number;
	}

	@Override
	public void print() {
		for (int i = 1; i <= number; i++) {
			super.appender(i);
		}
	}

}
