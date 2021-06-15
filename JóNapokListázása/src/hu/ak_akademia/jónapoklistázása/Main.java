package hu.ak_akademia.jónapoklistázása;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) throws InterruptedException, IOException {
		Stream.iterate(LocalDateTime.of(2020, 1, 1, 0, 0, 0),
				date -> date.isBefore(LocalDateTime.of(2021, 1, 1, 0, 0, 0)),
				date -> isCurrentDayGood(date)
						? date = LocalDateTime.of(date.getYear(), date.getMonthValue(), date.getDayOfMonth() + 1, 0, 0,
								0)
						: date.plusSeconds(1))
				.filter(date -> isCurrentDayGood(date))
				.forEach(date -> System.out.println(date.format(DateTimeFormatter.ofPattern("yyy.MM.dd HH:mm:ss"))));
	}

	static int getAdditionOfLocalDateTimeValues(LocalDateTime date) {
		return date.getYear() + date.getMonthValue() + date.getDayOfMonth() + date.getHour() + date.getMinute()
				+ date.getSecond();
	}

	static boolean isCurrentDayGood(LocalDateTime date) {
		return getAdditionOfLocalDateTimeValues(date) % 184 == 0;
	}

}
