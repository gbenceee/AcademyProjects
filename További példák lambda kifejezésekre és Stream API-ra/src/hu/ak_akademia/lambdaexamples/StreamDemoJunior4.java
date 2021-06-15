package hu.ak_akademia.lambdaexamples;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamDemoJunior4 {

	public static void main(String[] args) {
		List<String> names = List.of("Tibor", "Gábor", "Dani", "Gábor", "Andris");

		names.stream()
				.filter(name -> name.length() >= 5)// csak az 5 vagy annál hosszabb elemeket engedi tovább
				.map(name -> name + " (" + name.length() + ")") // Andris (6)
				.map(name -> name.toUpperCase()) // ANDRIS (6)
				.filter(name -> name.contains("I")) // csak az I-t tartalmazó neveket engedi tovább
				.sorted() // abc sorrendbe rendezi az elemeket
				.limit(1L) // csak az első 1 elemet adja vissza
				// .forEach(length -> System.out.println(length));
				.forEach(System.out::println);

		System.out.println("----------");

		names.stream()
				.collect(Collectors.toSet())
				.forEach(System.out::println);

		System.out.println("----------");

		names.stream()
				.distinct()
				.forEach(System.out::println);

		System.out.println("----------");

		// 50-ig írjuk ki növekvő sorrendben a pozitív páros egész számokat, mindegyiket
		// új sorba
		IntStream.range(1, 50)
				.filter(i -> i % 2 == 0)
				.forEach(System.out::println);

		System.out.println("----------");

		System.out.println(names.stream()
				.reduce((name1, name2) -> name1 + "-" + name2)
				.get());

		System.out.println("----------");

		System.out.println(names.stream()
				.collect(Collectors.joining()));

		System.out.println("----------");

		System.out.println(names.stream()
				.collect(Collectors.joining(";")));

		System.out.println("----------");

		System.out.println(names.stream()
				.collect(Collectors.joining(";", "{", "}")));

		System.out.println("----------");

		names.stream()
				.map(s -> new StringBuilder(s).reverse()
						.toString())
				.forEach(System.out::println);

		System.out.println("----------");

		List<Integer> numbers = List.of(1, 4, 10, 1000, 87, 1, 69);

		System.out.println("Összeg: " + numbers.stream()
				.mapToInt(n -> n.intValue())
				.sum());
		System.out.println("Átlag: " + numbers.stream()
				.mapToInt(n -> n.intValue())
				.average()
				.getAsDouble());
		System.out.println("Legkisebb szám: " + numbers.stream()
				.mapToInt(n -> n.intValue())
				.min()
				.getAsInt());
		System.out.println("Legnagyobb szám: " + numbers.stream()
				.mapToInt(n -> n.intValue())
				.max()
				.getAsInt());
		System.out.println("Számok darabszáma: " + numbers.stream()
				.count());

		System.out.println("----------");

		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= 7; i += 2) {
			list.add(i);
		}

		IntStream.rangeClosed(1, 7)
				.filter(i -> i % 2 != 0)
				.forEach(i -> System.out.println(IntStream.range(0, i)
						.mapToObj(n -> "*")
						.collect(Collectors.joining())));

	}

	private static String toAsterisks(int number) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < number; i++) {
			stringBuilder.append("*");
		}
		return stringBuilder.toString();
	}

	private static String reverse(String word) {
		StringBuilder stringBuilder = new StringBuilder(word);
		return stringBuilder.reverse()
				.toString();
	}
}
