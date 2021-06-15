package hu.ak_akademnia.lambdaexpressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.ToIntFunction;

public class LambdaExpression {

	public static void main(String[] args) {
		List<String> words = new ArrayList<>();
		words.add("zebra");
		words.add("asztal");
		words.add("szék");
		words.add("fa");
		words.add("folyó");
		words.add("kerítés");
		System.out.println(words);
		// Comparator<String>: a változó típusa egy funkcionális interfész
		// funkcionális interfész = olyan interfész, aminek pontosan 1 absztrakt
		// metódusa van

		// myComparator: a változó neve (azonosítója)

		// (s1, s2) -> s1.length() - s2.length(): lambda kifejezés, mint a myComparator
		// változó értéke
		Comparator<String> myComparator = (s1, s2) -> s1.length() - s2.length();
		Collections.sort(words, myComparator);

//      Comparator<String> myComparator = new StringLengthComparator();
//      Collections.sort(words, myComparator);
		System.out.println(words);

		// bemenet: String
		// kimenet: int
//      ToIntFunction<String> lambda1 = s1 -> s1.length();
		ToIntFunction<String> lambda1 = String::length;
		System.out.println(lambda1.applyAsInt("Béla"));
//      calculate(50, 70);
//      Consumer<String> printLogic = s -> System.out.println(s);
		Consumer<String> printLogic = System.out::println;
		printLogic.accept("Hello");
		printLogic.accept("World");

		IntBinaryOperator addition = (x, y) -> x + y;
		IntBinaryOperator subtraction = (x, y) -> x - y;
		IntBinaryOperator multiplication = (x, y) -> x * y;
		IntBinaryOperator division = (x, y) -> x / y;
		IntBinaryOperator exponentiation = (x, y) -> {
			int result = 1;
			for (int i = 0; i < y; i++) {
				result *= x;
			}
			return result;
		};
//      Operation exponentiation = new ExponentiationOperation();
		int result = calculate(2, 10, exponentiation);
		System.out.println(result);

		BooleanSupplier headsOrTails = () -> new Random().nextBoolean();
		System.out.println(headsOrTails.getAsBoolean());
		System.out.println(headsOrTails.getAsBoolean());
		System.out.println(headsOrTails.getAsBoolean());

		Function<String, Integer> getLengthOfString = String::length;
		System.out.println(getLengthOfString.apply("Béla"));
		System.out.println(getLengthOfString.apply("Aladár"));
		System.out.println(getLengthOfString.apply("Zoltán"));
		System.out.println(getLengthOfString.apply("Géza"));

		sort(18, 77, (a, b) -> a % 10 - b % 10);
	}

	static int calculate(int a, int b, IntBinaryOperator operation) {
		return operation.applyAsInt(a, b);
	}

	static void sort(int a, int b, IntBinaryOperator comparator) {
		if (comparator.applyAsInt(a, b) < 0) {
			System.out.println("a előrébb van a sorrendben mint b");
		} else if (comparator.applyAsInt(a, b) > 0) {
			System.out.println("b előrébb van a sorrendben mint a");
		} else {
			System.out.println("a és b azonos helyen szerepel a sorrendben");
		}
	}

}
