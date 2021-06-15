package hu.ak_akademia.dataoutputstreamdemo;

import java.io.Serializable;

public class Person implements Serializable {
	private static final long serialVersionUID = 3475934579L;
	private int age;
	private DateOfBirth dateOfBirth;

	public Person(int age, DateOfBirth dateOfBirth) {
		this.age = age;
		this.dateOfBirth = dateOfBirth;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public DateOfBirth getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(DateOfBirth dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [age=");
		builder.append(age);
		builder.append(", dateOfBirth=");
		builder.append(dateOfBirth);
		builder.append("]");
		return builder.toString();
	}

}
