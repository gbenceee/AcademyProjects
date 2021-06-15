package hu.ak_akademia.lambdakifejezésekgyakorlása;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringPermutationGenerator {
	public Stream<String> generatePermutations(String givenString) {
		if (givenString.length() == 0) {
			return Stream.of("");
		}
		return IntStream.range(0, givenString.length()).boxed().flatMap(
				index -> generatePermutations(givenString.substring(0, index) + givenString.substring(index + 1))
						.map(t -> givenString.charAt(index) + t));

	}
}
