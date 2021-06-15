package hu.ak_akademia.dateandtimeapidemo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateDemo {

	public static void main(String[] args) {
		LocalDate today = LocalDate.now();

		LocalDate otherDay = today;

		otherDay = otherDay.minusYears(1);
//	      otherDay = otherDay.minusMonths(3);
		otherDay = otherDay.minusWeeks(5);
		otherDay = otherDay.minusDays(7);

		otherDay = otherDay.plusYears(1);
//	      otherDay = otherDay.plusMonths(3);
		otherDay = otherDay.plusWeeks(5);
		otherDay = otherDay.plusDays(7);

		otherDay = otherDay.withYear(2040);

		System.out.println(today);
		System.out.println(otherDay);

		// dátum -> String konvertálás
		String formattedDate = otherDay.format(DateTimeFormatter.ofPattern("yyyy. MM. dd."));
		System.out.println(formattedDate);

		// String -> dátum kovertálás
		String userDefinedDate = "1999. 11. 17.";
		LocalDate parsedDate = LocalDate.parse(userDefinedDate, DateTimeFormatter.ofPattern("yyyy. MM. dd."));
		System.out.println("A megadott év: " + parsedDate.getYear());
		System.out.println("A megadott hónap: " + parsedDate.getMonthValue());
		System.out.println("A megadott nap: " + parsedDate.getDayOfMonth());
		System.out.format("Az év %d. napja.%n", parsedDate.getDayOfYear());
		System.out.format("A hét %d. napja.%n", parsedDate.getDayOfWeek()
				.getValue());
	}

}
