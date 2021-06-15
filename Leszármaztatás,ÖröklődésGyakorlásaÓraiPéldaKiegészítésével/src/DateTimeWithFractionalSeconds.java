
public class DateTimeWithFractionalSeconds extends DateTime {
	String[] months = { "", "Január", "Február", "Március", "Április", "Május", "Június", "Július", "Augusztus", "Szeptember", "Október", "November", "December" };
	private int fractionalSecond;

	public DateTimeWithFractionalSeconds(int year, int month, int day) {
		super(year, month, day);
	}

	public DateTimeWithFractionalSeconds(int hour, int minute, int second, int fractionalSecond) {
		super(hour, minute, second);
		this.fractionalSecond = fractionalSecond;
	}

	public DateTimeWithFractionalSeconds(int year, int month, int day, int hour, int minute, int second, int fractionalSecond) {
		this(year, month, day, hour, minute, second);
		this.fractionalSecond = fractionalSecond;
	}

	public DateTimeWithFractionalSeconds(int year, int month, int day, int hour, int minute, int second) {
		super(year, month, day, hour, minute, second);
	}

	public int getFractionalSecond() {
		return fractionalSecond;
	}

	public void setFractionalSecond(int fractionalSecond) {
		this.fractionalSecond = fractionalSecond;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(months[super.getMonth()])
				.append(". ");
		builder.append(String.format("%02d", super.getDay()))
				.append(". ");
		builder.append(String.format("%04d", super.getYear()))
				.append(". ");
		if (super.getHour() > 0 && super.getHour() < 13) {
			builder.append("de. ");
		} else if (super.getHour() > 12 && super.getHour() <= 24) {
			builder.append("du. ");
		}
		if (super.getHour() > 0 && super.getHour() < 13) {
			builder.append(String.format("%02d", super.getHour()))
					.append(":");
		} else if (super.getHour() > 12 && super.getHour() <= 24) {
			builder.append(String.format("%02d", super.getHour() - 12))
					.append(":");
		}
		builder.append(String.format("%02d", super.getMinute()))
				.append(":");
		builder.append(String.format("%02d", super.getSecond()))
				.append(".");
		builder.append(String.format("%04d", fractionalSecond));
		return builder.toString();
	}

}