
public class DateTime extends Date {
	private int hour;
	private int minute;
	private int second;

	// példány inicializátor
	{
		System.out.println("DateTime 1. példány inicializátora lefutott.");
	}

	// statikus inicializátor
	static {
		System.out.println("DateTime 1. statikus inicializátora lefutott.");
	}

	public DateTime(int year, int month, int day) {
		super(year, month, day); // <- ősosztály konstruktorának meghívása
		System.out.println("DateTime 3 paraméteres konstruktora lefutott.");
	}

	public DateTime(int year, int hour, int minute, int second) {
		super(year, 1, 1); // <- ősosztály konstruktorának meghívása
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		System.out.println("DateTime 4 paraméteres konstruktora lefutott.");
	}

	public DateTime(int year, int month, int day, int hour, int minute, int second) {
		super(year, month, day); // <- ősosztály konstruktorának meghívása
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		System.out.println("DateTime 6 paraméteres konstruktora lefutott.");
	}

	// statikus inicializátor
	static {
		System.out.println("DateTime 2. statikus inicializátora lefutott.");
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	// példány inicializátor
	{
		System.out.println("DateTime 2. példány inicializátora lefutott.");
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	@Override
	public String toString() {
		return super.toString() + " " + hour + ":" + minute + ":" + second;
	}

	// példány inicializátor
	{
		System.out.println("DateTime 3. példány inicializátora lefutott.");
	}

	// statikus inicializátor
	static {
		System.out.println("DateTime 3. statikus inicializátora lefutott.");
	}
}
