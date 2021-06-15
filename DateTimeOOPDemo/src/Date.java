
public class Date {
	private int year;
	private int month;
	private int day;

	// példány inicializátor
	{
		System.out.println("Date 1. példány inicializátora lefutott.");
	}

	// statikus inicializátor
	static {
		System.out.println("Date 1. statikus inicializátora lefutott.");
	}

	public Date(int year) {
		this.year = year;
		System.out.println("Date 1 paraméteres konstruktora lefutott.");
	}

	public Date(int year, int month) {
		this(year); // <- explicit konstruktorhívás
		this.month = month;
		System.out.println("Date 2 paraméteres konstruktora lefutott.");
	}

	public Date(int year, int month, int day) {
		this(year, month); // <- explicit konstruktorhívás
		this.day = day;
		System.out.println("Date 3 paraméteres konstruktora lefutott.");
	}

	// statikus inicializátor
	static {
		System.out.println("Date 2. statikus inicializátora lefutott.");
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	// példány inicializátor
	{
		System.out.println("Date 2. példány inicializátora lefutott.");
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return year + ". " + month + ". " + day + ".";
	}

	// példány inicializátor
	{
		System.out.println("Date 3. példány inicializátora lefutott.");
	}

	// statikus inicializátor
	static {
		System.out.println("Date 3. statikus inicializátora lefutott.");
	}
}
