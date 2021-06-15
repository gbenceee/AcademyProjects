package hu.ak_akademia.szóstatisztikakészítése;

import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderComparator {

	public Comparator<StringBuilder> descendingOrderComparator() {
		return Comparator.comparingDouble(this::convertStringToDouble).reversed();
	}

	public double convertStringToDouble(StringBuilder input) {
		StringBuilder digitsOnly = new StringBuilder(input);
		Pattern pattern = Pattern.compile(".[\\s\\S]*[\\t]|%");
		Matcher matcher = pattern.matcher(digitsOnly);
		digitsOnly.replace(0, digitsOnly.length(), matcher.replaceAll("").replaceAll(",", "."));
		return Double.parseDouble(digitsOnly.toString());
	}
}
