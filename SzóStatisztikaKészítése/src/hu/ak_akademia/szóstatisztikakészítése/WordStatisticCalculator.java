package hu.ak_akademia.szóstatisztikakészítése;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class WordStatisticCalculator {

	public ToIntFunction<String> countCharacters() {
		ToIntFunction<String> numberOfCharactersInWord = word -> word.length();
		return numberOfCharactersInWord;
	}

	public ToLongFunction<String> countVowels(List<Character> listOfVowels) {
		ToLongFunction<String> numberOfVowelsInWord = word -> word.chars()
				.filter(ch -> listOfVowels.contains(Character.valueOf((char) ch))).count();
		return numberOfVowelsInWord;
	}

	public ToLongFunction<String> countConsonants(List<Character> listOfConsonants) {
		ToLongFunction<String> numberOfConsonantsInWord = word -> word.chars()
				.filter(ch -> listOfConsonants.contains(Character.valueOf((char) ch))).count();
		return numberOfConsonantsInWord;
	}

	public BiFunction<Long, Integer, Double> calculatePercentageOfVowelOccurrences() {
		BiFunction<Long, Integer, Double> percentageOfVowelOccurrences = (Long numberOfVowels,
				Integer lengthOfWord) -> ((double) numberOfVowels / lengthOfWord) * 100.0;
		return percentageOfVowelOccurrences;
	}
}