package hu.ak_akademia.streamapi;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) throws IOException {
		List<String> words = List.of("zebra ", " asztal", "mező", "nap", "folyó", "fű");
		List<String> result = words.stream()
				.filter(word -> word.contains("a"))
				.filter(word -> word.length() > 3)
				.map(word -> word.trim())
				.collect(Collectors.toList());
//	              .forEach(System.out::println);
		System.out.println(result);
		// adott egy listányi szó
		// 1. feladat: minden szó mögé fűzzük hozzá a hosszát kerekzárójelben
		// példa: ["zebra", "asztal"] => ["zebra (5)", "asztal (6)"]
		// 2. feladat: csak az 'a' vagy 'e' betűt tartalmazó szavak legyenek kiírva

		List<String> wordsss = List.of("zebra", "asztal", "mező", "nap", "folyó", "fű");
		words.stream()
				.map(word -> word + " (" + word.length() + ")")
				.filter(word -> word.contains("a") || word.contains("e"))
				.forEach(System.out::println);

		Files.lines(Path.of("resources/input.txt"))
				.filter(line -> line.length() > 5)
				.collect(Collectors.toMap(word -> word.substring(0, 1), word -> List.of(word), (list1, list2) -> Stream.concat(list1.stream(), list2.stream())
						.sorted()
						.collect(Collectors.toList()), TreeMap::new))
				.entrySet()
				.stream()
				.forEach(System.out::println);
//		TreeMap<String, List<String>> map = Files.lines(Path.of("resources/input.txt"))
//      	.filter(line -> line.length() > 5)
//      	.collect(Collectors.toMap(word -> word.substring(0, 1), word -> List.of(word), (list1, list2) -> Stream.concat(list1.stream(), list2.stream())
//              	.sorted()
//             	 	.collect(Collectors.toList()), TreeMap::new));
//
//		map.entrySet()
//      	.stream()
//      	.forEach(System.out::println);
	}

}
