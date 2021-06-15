package hu.ak_akademia.lambdakifejezésekgyakorlása;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		String textWithoutCamelCase = "  i  hOpE  CSoNgOr   wILL acCePT MY hOMEwOrK ";
		Function<String, String> camelCaseConverter = stringWithoutCamelCase -> Stream
				.of(stringWithoutCamelCase.trim().split("\\s+"))
				.map(currentElement -> currentElement.substring(0, 1).toUpperCase()
						+ currentElement.substring(1).toLowerCase())
				.collect(Collectors.joining());
		System.out.println(camelCaseConverter.apply(textWithoutCamelCase));

		String textWithoutUnderlineAndUpperCaseLetters = "  i  hope  csongor   will  accept my  homework  ";
		Function<String, String> underlineAndLowerCaseModifier = stringWithoutUnderlineAndUpperCaseLetters -> Stream
				.of(stringWithoutUnderlineAndUpperCaseLetters.replaceAll("\\s", "_").toUpperCase())
				.collect(Collectors.joining());
		System.out.println(underlineAndLowerCaseModifier.apply(textWithoutUnderlineAndUpperCaseLetters));

		int lengthOfRandomlyGeneratedString = 10;
		Function<Integer, String> randomStringGenerator = lengthOfString -> new Random().ints(lengthOfString, 65, 101)
				.mapToObj(randomCharacter -> String.valueOf((char) randomCharacter)).collect(Collectors.joining());
		System.out.println(randomStringGenerator.apply(lengthOfRandomlyGeneratedString));

		String textToCountSpaces = "  i  hope  csongor   will  accept my  homework  ";
		Function<String, Integer> spaceCounter = stringToCountSpaces -> (int) stringToCountSpaces.chars()
				.filter(Character::isSpaceChar).count();
		System.out.println(spaceCounter.apply(textToCountSpaces));

		String textToCheckPalindrome = "level";
		Function<String, Boolean> palindromeChecker = stringToCheck -> IntStream.range(0, stringToCheck.length() / 2)
				.allMatch(index -> textToCheckPalindrome.charAt(index) == stringToCheck
						.charAt(stringToCheck.length() - index - 1));
		System.out.println(palindromeChecker.apply(textToCheckPalindrome));

		String stringToSortAlphabetically = "ihopecsongorwillacceptmyhomework";
		Function<String, String> alphabeticalSorter = stringToSort -> Stream.of(stringToSort.split("")).sorted()
				.collect(Collectors.joining());
		System.out.println(alphabeticalSorter.apply(stringToSortAlphabetically));

		int highestNumber = 20;
		IntStream.range(1, highestNumber).map(index -> 1 + (highestNumber - 1 - index)).forEach(System.out::println);

		PrimeNumberChecker check = new PrimeNumberChecker();
		Function<Integer, Boolean> prime = numberToDecide -> check.isPrime(numberToDecide);
		System.out.println(prime.apply(10));

		Set<Character> firstCharacterSet = new HashSet<>();
		firstCharacterSet.add('x');
		firstCharacterSet.add('y');
		firstCharacterSet.add('z');
		Set<Character> secondCharacterSet = new HashSet<>();
		secondCharacterSet.add('t');
		secondCharacterSet.add('v');
		secondCharacterSet.add('w');
		BiFunction<Set<Character>, Set<Character>, Set<String>> generateCartesianProductOfCharacterSets = (firstCharSet,
				secondCharSet) -> firstCharSet.stream()
						.flatMap(firstCharacter -> secondCharSet.stream()
								.map(secondCharacter -> firstCharacter.toString() + secondCharacter.toString()))
						.collect(Collectors.toSet());
		System.out.println(generateCartesianProductOfCharacterSets.apply(firstCharacterSet, secondCharacterSet));

		StringPermutationGenerator generator = new StringPermutationGenerator();
		Function<String, Set<String>> collectAllUniquePermutationsOfGivenString = givenString -> generator
				.generatePermutations(givenString).collect(Collectors.toSet());
		System.out.println(collectAllUniquePermutationsOfGivenString.apply("123"));
	}

}
