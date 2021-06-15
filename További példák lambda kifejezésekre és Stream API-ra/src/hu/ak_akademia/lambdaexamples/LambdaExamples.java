package hu.ak_akademia.lambdaexamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LambdaExamples {

	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> lambdaExpression1 = (a, b) -> a + b;
		System.out.println(lambdaExpression1.apply(5, 10));

		IntBinaryOperator lambdaExpression2 = (a, b) -> a + b;
		System.out.println(lambdaExpression2.applyAsInt(5, 10));

		IntSumFunction lambdaExpression3 = (a, b) -> a + b;
		System.out.println(lambdaExpression3.add(5, 10));

		Function<Double, Double> lambdaExpression4 = a -> -a;
		System.out.println(lambdaExpression4.apply(3.14));

		IntFunction<Integer> lambdaExpression5 = a -> -a;
		System.out.println(lambdaExpression5.apply(100));

		BiFunction<Integer, Integer, Integer> lambdaExpression6 = (Integer a, Integer b) -> a + b;
		System.out.println(lambdaExpression6.apply(10, 20));

		IntUnaryOperator lambdaExpression7 = (a) -> 2 * a;
		System.out.println(lambdaExpression7.applyAsInt(500));

		UnaryOperator<String> lambdaExpression8 = (String s) -> s.toLowerCase();
		System.out.println(lambdaExpression8.apply("ALMA!"));

		Function<String, Integer> lambdaExpression9 = s -> s.length();
		System.out.println(lambdaExpression9.apply("alma"));

		Supplier<String> lambdaExpression10 = () -> "körte";
		System.out.println(lambdaExpression10.get());

		Consumer<Object> lambdaExpression11 = System.out::println;
		lambdaExpression11.accept("alma");

		Predicate<Integer> lambdaExpression12 = a -> a < 10;
		System.out.println(lambdaExpression12.test(157));
		System.out.println(lambdaExpression12.test(1));
		System.out.println(lambdaExpression12.test(200));
		System.out.println(lambdaExpression12.test(5));

		IntTriFunction lambdaExpression13 = (a, b, c) -> {
			double sum = a + b + c;
			double average = sum / 3.0;
			return average;
		};
		System.out.println(lambdaExpression13.applyToDouble(1, 2, 3));

		String text = "az egymást tapasztó táposztó levelek képezte káposzta letépett levelein belül tapasztalt betétet mely a kopasztott káposzta törzse úgy hívják hogy torzsa";
		// 1. String -> String (megfordítja a String-et)
		// 2. String -> List<String> (szavakra szedi szét szóközök mentén)
		// 3. String -> int (a szó hossza)
		// 4. List<Integer> -> int (a számok összege)
		// 5. int -> void (kiírja a számot a standard kimenetre)

		// 1.
		// UnaryOperator<String> reverseLambda = a -> {
		// StringBuilder stringBuilder = new StringBuilder(a);
		// StringBuilder reversedString = stringBuilder.reverse();
		// return reversedString.toString();
		// };
		UnaryOperator<String> reverseLambdaExpression = s -> new StringBuilder(s).reverse()
				.toString();

		// 2.
		Function<String, List<String>> splitToWordsLambdaExpression = s -> Arrays.asList(s.split(" "));

		// 3.
		Function<String, Integer> wordLengthLambdaExpression = s -> s.length();

		// 4.
		Function<List<Integer>, Integer> sumOfNumbersLambdaExpressions = numbers -> {
			int sum = 0;
			for (int i = 0; i < numbers.size(); i++) {
				sum += numbers.get(i);
			}
			return sum;
		};

		// 5.
		Consumer<Integer> printToConsoleLambdaExpression = System.out::println;

		// végrehajtás
		// 1.
		String reversedText = reverseLambdaExpression.apply(text);

		// 2.
		List<String> words = splitToWordsLambdaExpression.apply(reversedText);

		// 3.
		List<Integer> wordLengthList = new ArrayList<>();
		for (String word : words) {
			Integer wordLength = wordLengthLambdaExpression.apply(word);
			wordLengthList.add(wordLength);
		}

		// 4.
		Integer totalNumberOfLetters = sumOfNumbersLambdaExpressions.apply(wordLengthList);

		// 5.
		printToConsoleLambdaExpression.accept(totalNumberOfLetters);
	}

}
