package hu.ak_akademia.previoustaskswithstreamapi;

import java.util.stream.IntStream;

public class FizzBuzz {

	public static void main(String[] args) {
		IntStream.rangeClosed(1, 100)
				.mapToObj(number -> number + (number % 3 == 0 ? " Fizz" : "") + (number % 5 == 0 ? " Buzz" : ""))
				.forEach(System.out::println);
	}

}
