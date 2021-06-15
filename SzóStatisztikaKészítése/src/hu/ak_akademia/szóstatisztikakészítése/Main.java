package hu.ak_akademia.szóstatisztikakészítése;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class Main {

	public static void main(String[] args) throws IOException {
		List<Character> listOfVowels = List.of('a', 'á', 'e', 'é', 'i', 'í', 'o', 'ó', 'ö', 'ő', 'u', 'ú', 'ü', 'ű');
		List<Character> listOfConsonants = List.of('b', 'c', 'c', 's', 'd', 'd', 'z', 'd', 'z', 's', 'f', 'g', 'g', 'y',
				'h', 'j', 'k', 'l', 'l', 'y', 'm', 'n', 'n', 'y', 'p', 'q', 'r', 's', 's', 'z', 't', 't', 'y', 'v', 'w',
				'x', 'y', 'z', 'z', 's');
		List<String> listOfWords = new FileInputHandler().readAndStoreDataFromFileInput("resources/words.txt");
		List<StringBuilder> listOfWordStatistics = new ArrayList<>();
		WordStatisticCalculator counter = new WordStatisticCalculator();
		ToIntFunction<String> countCharactersInWord = counter.countCharacters();
		ToLongFunction<String> countVowelsOfWord = counter.countVowels(listOfVowels);
		ToLongFunction<String> countConsonantsOfWord = counter.countConsonants(listOfConsonants);
		BiFunction<Long, Integer, Double> countPercentageOfVowelOccurrences = counter
				.calculatePercentageOfVowelOccurrences();
		for (int i = 0; i < listOfWords.size(); i++) {
			listOfWordStatistics.add(new StringBuilder().append(listOfWords.get(i)).append("\t")
					.append(countCharactersInWord.applyAsInt(listOfWords.get(i))).append("\t")
					.append(countVowelsOfWord.applyAsLong(listOfWords.get(i))).append("\t")
					.append(countConsonantsOfWord.applyAsLong(listOfWords.get(i))).append("\t")
					.append(String.format("%1.2f%%",
							countPercentageOfVowelOccurrences.apply(countVowelsOfWord.applyAsLong(listOfWords.get(i)),
									countCharactersInWord.applyAsInt(listOfWords.get(i))))));
		}
		listOfWordStatistics.sort(new OrderComparator().descendingOrderComparator());
		new FileOutputHandler().printWordStatisticToFile(listOfWordStatistics, "resources/word-statistics.txt");

	}

}