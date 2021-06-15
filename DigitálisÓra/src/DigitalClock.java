
public class DigitalClock {
	private int hour;
	private int minute;
	private int second;

	public DigitalClock() {
	}

	public DigitalClock(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	public void increaseSecondByOne() {
		if (second == 59) {
			increaseMinuteByOne();
			setSecond(0);
		} else {
			setSecond(second + 1);
		}
	}

	private void increaseMinuteByOne() {
		if (minute == 59) {
			setMinute(0);
			increaseHourByOne();
		} else {
			setMinute(minute + 1);
		}
	}

	private void increaseHourByOne() {
		if (hour == 23) {
			setHour(0);
		} else {
			setHour(hour + 1);
		}
	}

	private void decreaseSecondByOne() {
		if (second == 0) {
			decreaseMinuteByOne();
			setSecond(59);
		} else {
			setSecond(second - 1);
		}
	}

	private void decreaseMinuteByOne() {
		if (minute == 0) {
			setMinute(59);
			decreaseHourByOne();
		} else {
			setMinute(minute - 1);
		}
	}

	private void decreaseHourByOne() {
		if (hour == 0) {
			setHour(23);
		} else {
			setHour(hour - 1);
		}
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

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("%02d", hour))
				.append(":");
		builder.append(String.format("%02d", minute))
				.append(":");
		builder.append(String.format("%02d", second));
		return builder.toString();
	}

}