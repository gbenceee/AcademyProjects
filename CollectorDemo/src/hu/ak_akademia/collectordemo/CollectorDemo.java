package hu.ak_akademia.collectordemo;

import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorDemo {

	public static void main(String[] args) {
		List<String> words = List.of("apple", "pear", "melon", "walnut", "lettuce", "salad", "ananas", "banana", "apricot", "almond", "peach");
//      List<String> otherWords = List.of("hello", "world", "test");
//      List<String> concatenatedList = Stream.concat(words.stream(), otherWords.stream())
//              .collect(Collectors.toList());
//      System.out.println(concatenatedList);
		// String -> SortedSet<String>
		// "a" -> ["almond", "ananas", "apple", "apricot"]
		// "b" -> ["banana"]
		// "m" -> ["melon"]
		// "p" -> ["peach", "pear"]
		// "s" -> ["salad"]
		// "w" -> ["walnut"]
		// SortedMap<String, SortedSet<String>>
//      TreeMap<String, List<String>> map = words.stream()
//              .collect(Collectors.toMap(word -> word.substring(0, 1), word -> List.of(word),
//                      (list1, list2) -> Stream.concat(list1.stream(), list2.stream()).sorted()
//                      .collect(Collectors.toList()), TreeMap::new));
		SortedMap<String, SortedSet<String>> map = words.stream()
				.collect(Collectors.toMap(word -> word.substring(0, 1), // key mapper
						word -> new TreeSet<>(Set.of(word)), // value mapper
						(set1, set2) -> Stream.concat(set1.stream(), set2.stream())
								.collect(Collectors.toCollection(TreeSet::new)), // merge function
						TreeMap::new)); // supplier
		System.out.println(map);
	}

}
