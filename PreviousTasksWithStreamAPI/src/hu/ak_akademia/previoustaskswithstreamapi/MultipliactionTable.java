package hu.ak_akademia.previoustaskswithstreamapi;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MultipliactionTable {

//  1   2   3   4   5   6   7   8   9   10
//  2   4   6   8   10  12  14  16  18  20
//  3   6   9   12  15  18  21  24  27  30
//  4   8   12  16  20  24  28  32  36  40
//  5   10  15  20  25  30  35  40  45  50
//  6   12  18  24  30  36  42  48  54  60
//  7   14  21  28  35  42  49  56  63  70
//  8   16  24  32  40  48  56  64  72  80
//  9   18  27  36  45  54  63  72  81  90
//  10  20  30  40  50  60  70  80  90  100
	public static void main(String[] args) {
		IntStream.rangeClosed(1, 10)
				.mapToObj(row -> IntStream.iterate(row, n -> n + row)
						.limit(10)
						.boxed()
						.map(number -> String.format("%4d", number))
						.collect(Collectors.joining()))
				.forEach(System.out::println);
		System.out.println("----------");

// másik megoldás:
		List<Integer> multiplicationTableNumbers = IntStream.rangeClosed(1, 10)
				.flatMap(number -> IntStream.iterate(number, n -> n + number)
						.limit(10))
				.boxed()
				.collect(Collectors.toList());
		for (int row = 0; row < 10; row++) {
			for (int column = 0; column < 10; column++) {
				System.out.format("%4d", multiplicationTableNumbers.get(10 * row + column));
			}
			System.out.format("%n");
		}
	}

}
