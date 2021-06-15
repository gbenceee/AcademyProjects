package hu.ak_akademia.previoustaskswithstreamapi;

import java.util.Optional;
import java.util.stream.Stream;

public class FibonacciNumbers {
	/**
	 * Ellenpélda lambda kifejezés és Stream API használatára. Ha az aggregáló
	 * műveletekben olyan utasítást írunk, ami a környező scope állapotán változtat,
	 * akkor ez már nem tisztán funkcionális programozás. Ez kerülendő.
	 */
//  public static void main(String[] args) {
//      List<Integer> otherNumbers = new ArrayList<>();
//      List<Integer> numbers = List.of(5, 2, 7, 0, 9, -10, 1000);
//      numbers.stream()
//              .forEach(number -> otherNumbers.add(-number));
//      System.out.println(otherNumbers);
//  }
	public static void main(String[] args) {
		class Fibo {
			long previous;
			long oneBeforePrevious;

			public Fibo(long previous, long oneBeforePrevious) {
				this.previous = previous;
				this.oneBeforePrevious = oneBeforePrevious;
			}

			@Override
			public String toString() {
				return Long.toString(previous);
			}

		}
		Stream.iterate(new Fibo(1, 0), fibo -> new Fibo(fibo.previous + fibo.oneBeforePrevious, fibo.previous))
				.limit(80)
				.forEach(System.out::println);
		System.out.println("----------");
		long result1 = getFibonacci(20);
		long result2 = getFibonacci(40);
		long result3 = getFibonacci(60);
		long result4 = getFibonacci(80);
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		System.out.println("----------");
		Optional<String> result = Stream.iterate("alma", s -> s + "!")
				.skip(10)
				.findFirst();
		result.isPresent();
		result.isEmpty();
		Optional<String> hello = Optional.of("hello");
		System.out.println(hello.get());
		System.out.println(result.get());
	}

	private static long getFibonacci(long limit) {
		long[] result = Stream.iterate(new long[] { 1, 0 }, fibo -> new long[] { fibo[0] + fibo[1], fibo[0] })
//              .limit(limit)
				.skip(limit - 1)
				.findFirst()
				.get();
		return result[0];
	}
}
