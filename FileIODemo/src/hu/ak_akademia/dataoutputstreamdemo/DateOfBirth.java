package hu.ak_akademia.dataoutputstreamdemo;

import java.io.Serializable;

public class DateOfBirth implements Serializable {
	private static final long serialVersionUID = 3475934L;
	private int year;
	private int month;
	private int day;

	public DateOfBirth(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
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

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Date [year=");
		builder.append(year);
		builder.append(", month=");
		builder.append(month);
		builder.append(", day=");
		builder.append(day);
		builder.append("]");
		return builder.toString();
	}

}
