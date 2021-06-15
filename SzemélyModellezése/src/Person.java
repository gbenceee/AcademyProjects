import java.util.Scanner;

public class Person {
	static Scanner scan = new Scanner(System.in);

	String name;
	int dateOfBirth;

	public Person() {

	}

	public Person(String name, int dateOfBirth) {
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(int dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public static void main(String[] args) {
		Date[] arrayOfDates = new Date[5];
		int year;
		int month;
		int day;
		for (int i = 0; i < arrayOfDates.length; i++) {
			arrayOfDates[i] = new Date();
			year = scanNumberFromUser("Kérem, adja meg az évet.");
			arrayOfDates[i].setYear(year);
			month = scanNumberFromUser("Kérem, adja meg a hónapot.");
			arrayOfDates[i].setMonth(month);
			day = scanNumberFromUser("Kérem, adja meg a napot.");
			arrayOfDates[i].setDay(day);
		}
		for (int i = 0; i < arrayOfDates.length; i++) {
			if (Date.isLeapYear(arrayOfDates[i].getYear())) {
				System.out.print(arrayOfDates[i]);
				System.out.print(" Szökőév!");
				System.out.println();
			}
		}
		Date date = new Date();
		year = scanNumberFromUser("Kérem, adja meg az évet.");
		date.setYear(year);
		month = scanNumberFromUser("Kérem, adja meg a hónapot.");
		date.setMonth(month);
		day = scanNumberFromUser("Kérem, adja meg a napot.");
		date.setDay(day);
		for (int i = date.getYear(); i > 0; i--) {
			if (Date.isLeapYear(i)) {
				System.out.println("A megadott évhez legközelebb eső kisebb szökőév " + i);
				break;
			}
		}
		for (int i = date.getYear(); i < 3000; i++) {
			if (Date.isLeapYear(i)) {
				System.out.println("A megadott évhez legközelebb eső nagyobb szökőév " + i);
				break;
			}
		}
		for (int i = 0; i <= 3000; i++) {
			if (Date.isLeapYear(i)) {
				System.out.println(i + " szökőév.");
			}
		}
		Person person = new Person("Gál Bence", 1996);
		System.out.println(person);
	}

	static int scanNumberFromUser(String message) {
		System.out.println(message);
		int number = scan.nextInt();
		return number;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append(" ");
		builder.append(dateOfBirth);
		return builder.toString();
	}
}