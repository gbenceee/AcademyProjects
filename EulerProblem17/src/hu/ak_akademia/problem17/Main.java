package hu.ak_akademia.problem17;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> firstTenNumbers = List.of("", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");
		List<String> fromTenToNineteen = List.of("ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen");
		List<String> numbers = List.of("", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety");
		String hundred = "hundred";
		String output = "";
		int number = 999;
		for (int i = 1; i <= number; i++) {
			if (i > 99) {
				if (i / 100 != 0) {
					output += firstTenNumbers.get(i / 100) + hundred;
				}
				if (i % 100 != 0) {
					output += "and";
				}
			}
			int index = i % 100;
			if (index > 19) {
				output += numbers.get(index / 10);
			}
			if (index >= 10 && index <= 19) {
				output += fromTenToNineteen.get(index % 10);
			} else if (index % 10 != 0) {
				output += firstTenNumbers.get(index % 10);
			}

		}
		output += "onethousand";
		System.out.println(output.length());

	}

}
