import java.util.Scanner;

public class IdőMegjelenítéseAngolul {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		String[] arrayOfHours = { "midnight", "one", "two", "three", "dawn", "five", "six", "seven", "eight", "nine",
				"ten", "eleven", "noon", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"eleven", "midnight" };
		String[] arrayOfMinutes = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen", "seventeen", "eighteen", "nineteen",
				"twenty", "twenty-one", "twenty-two", "twenty-three", "twenty-four", "twenty-five", "twenty-six",
				"twenty-seven", "twenty-eight", "twenty-nine", "half" };
		int hour;
		int minute;
		do {
			hour = scanTimeFromUser("Kérem, adja meg az órát.: ");
			if (isHourInvalid(hour)) {
				System.out.println("Az óra csak 0 és 23 közötti lehet.");
			}
		} while (isHourInvalid(hour));
		do {
			minute = scanTimeFromUser("Kérem, adja meg a percet.: ");
			if (isMinuteInvalid(minute)) {
				System.out.println("A perc csak 0 és 59 közötti lehet.");
			}
		} while (isMinuteInvalid(minute));
		if ((hour == 0 || hour == 4 || hour == 12) && minute == 0) {
			System.out.println("It is " + arrayOfHours[hour] + ".");
		} else if (minute == 0) {
			System.out.println("It is " + arrayOfHours[hour] + " o'clock.");
		} else if (minute < 31) {
			System.out.println("It is " + arrayOfMinutes[minute] + " past " + arrayOfHours[hour] + ".");
		} else if (minute > 30) {
			System.out.println("It is " + arrayOfMinutes[60 - minute] + " to " + arrayOfHours[hour + 1] + ".");
		}

	}

	static int scanTimeFromUser(String message) {
		System.out.println(message);
		int time = scan.nextInt();
		return time;
	}

	static boolean isHourInvalid(int hour) {
		return hour > 23 || hour < 0;
	}

	static boolean isMinuteInvalid(int minute) {
		return minute > 59 || minute < 0;
	}

}
