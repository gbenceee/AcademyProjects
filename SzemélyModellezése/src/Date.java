
public class Date {
	int[] numberOfDaysInEveryMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	String[] months = { "", "január", "február", "március", "április", "május", "június", "július", "augusztus", "szeptember", "október", "november", "december" };
	private int year;
	private int month;
	private int day;
	private boolean prettyPrint;

	public Date() {
	}

	public Date(int year, int month, int day, boolean prettyPrint) {
		this.year = year;
		if (isYearInvalid(year)) {
			changeYearToMinusOne();
		}
		this.month = month;
		if (isMonthInvalid(month)) {
			changeMonthToMinusOne();
		}
		this.day = day;
		if (isLeapYear(year) && month == 2 && day <= 29 && day > 0) {
			this.day = day;
		} else if (isDayInvalid(day, month)) {
			changeDayToMinusOne();
		}
		this.prettyPrint = prettyPrint;
	}

	private boolean isBetween(Date firstDate, Date secondDate, Date dateToCheck) {
		boolean result = false;
		if (isBefore(firstDate, dateToCheck) && isAfter(secondDate, dateToCheck)) {
			result = true;
		} else if (isBefore(secondDate, dateToCheck) && isAfter(firstDate, dateToCheck)) {
			result = true;
		}
		return result;
	}

	private boolean isBefore(Date dateBeforeDateToCheck, Date dateToCheck) {
		if (dateBeforeDateToCheck.getYear() < dateToCheck.getYear()) {
			return true;
		} else if (dateBeforeDateToCheck.getYear() == dateToCheck.getYear()) {
			if (dateBeforeDateToCheck.getMonth() < dateToCheck.getMonth()) {
				return true;
			} else if (dateBeforeDateToCheck.getMonth() == dateToCheck.getMonth()) {
				if (dateBeforeDateToCheck.getDay() < dateToCheck.getDay()) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isAfter(Date dateAfterDateToCheck, Date dateToCheck) {
		if (dateAfterDateToCheck.getYear() > dateToCheck.getYear()) {
			return true;
		} else if (dateAfterDateToCheck.getYear() == dateToCheck.getYear()) {
			if (dateAfterDateToCheck.getMonth() > dateToCheck.getMonth()) {
				return true;
			} else if (dateAfterDateToCheck.getMonth() == dateToCheck.getMonth()) {
				if (dateAfterDateToCheck.getDay() > dateToCheck.getDay()) {
					return true;
				}
			}
		}
		return false;
	}

	static boolean isLeapYear(int year) {
		if (year % 100 == 0 && year % 400 == 0) {
			return true;
		} else if (year % 4 == 0) {
			if (year % 100 == 0) {
				return false;
			}
			return true;
		}
		return false;
	}

	private boolean isYearInvalid(int year) {
		return year < 0 || year > 3000;
	}

	private boolean isMonthInvalid(int month) {
		return month < 1 || month > 12;
	}

	private boolean isDayInvalid(int day, int month) {
		return day < 1 || day > numberOfDaysInEveryMonth[month];
	}

	private void changeYearToMinusOne() {
		System.out.println("Érvénytelen évszámot adott meg, ezért az évszám -1.");
		this.year = -1;
	}

	private void changeMonthToMinusOne() {
		System.out.println("Érvénytelen hónapot adott meg, ezért a hónap -1.");
		this.month = -1;
	}

	private void changeDayToMinusOne() {
		System.out.println("Érvénytelen napot adott meg, ezért a nap -1.");
		this.day = -1;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (isYearInvalid(year)) {
			changeYearToMinusOne();
		} else {
			this.year = year;
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
		if (isMonthInvalid(month)) {
			changeMonthToMinusOne();
		}
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
		if (isLeapYear(year) && month == 2 && day <= 29 && day > 0) {
			this.day = day;
		} else if (isDayInvalid(day, month)) {
			changeDayToMinusOne();
		}
	}

	public boolean isPrettyPrint() {
		return prettyPrint;
	}

	public void setPrettyPrint(boolean prettyPrint) {
		this.prettyPrint = prettyPrint;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + day;
		result = prime * result + month;
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Date other = (Date) obj;
		if (day != other.day)
			return false;
		if (month != other.month)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(year);
		builder.append(".");
		if (prettyPrint) {
			builder.append(months[month]);
		} else {
			builder.append(String.format("%02d", month));
		}
		builder.append(".");
		builder.append(String.format("%02d", day));
		builder.append(".");
		return builder.toString();
	}

}