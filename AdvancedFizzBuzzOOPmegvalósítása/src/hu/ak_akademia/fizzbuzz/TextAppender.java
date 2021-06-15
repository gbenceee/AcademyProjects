package hu.ak_akademia.fizzbuzz;

public abstract class TextAppender implements Print {
	void appender(int number) {
		if (number % 15 == 0) {
			System.out.println(number + " FIZZ BUZZ");
		} else if (number % 5 == 0) {
			System.out.println(number + " BUZZ");
		} else if (number % 3 == 0) {
			System.out.println(number + " FIZZ");
		} else {
			System.out.println(number);
		}
	}
}
