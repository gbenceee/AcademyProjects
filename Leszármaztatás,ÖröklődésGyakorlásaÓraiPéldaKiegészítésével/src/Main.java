import java.util.Scanner;

public class Main {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		Date today = new Date(2020, 1, 5);// implicit konstruktorhívás a new kulcsszóval
		System.out.println(today);

		Date yesterday = new Date(2020, 1, 4);// implicit konstruktorhívás a new kulcsszóval
		System.out.println(yesterday);

		Date tomorrow = new Date(2020, 1, 6);// implicit konstruktorhívás a new kulcsszóval
		System.out.println(tomorrow);

		DateTime now = new DateTime(2020, 1, 5, 10, 51, 7);// implicit konstruktorhívás a new kulcsszóval
		System.out.println(now);

		DateTime orderLunch = new DateTime(2020, 1, 5, 11, 0, 0);// implicit konstruktorhívás a new kulcsszóval
		System.out.println(orderLunch);

		Date thisMonth = new Date(2020, 1);
		System.out.println(thisMonth);

		Date thisYear = new Date(2020);
		System.out.println(thisYear);

		Date thisDay = new Date(2020, 1, 5);
		System.out.println(thisDay);

		DateTime meetingTime = new DateTime(2020, 13, 30, 0);
		System.out.println(meetingTime);

		DateTime sometime = new DateTime(2020, 1, 5, 1);
		System.out.println(sometime);

		in.close();
	}

	private static int getInt(String message) {
		System.out.println(message);
		int number = in.nextInt();
		in.nextLine();
		return number;
	}
}