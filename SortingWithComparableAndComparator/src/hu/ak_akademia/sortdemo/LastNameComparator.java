package hu.ak_akademia.sortdemo;

import java.util.Comparator;

public class LastNameComparator implements Comparator<Person> {

	@Override
	public int compare(Person person1, Person person2) {
		String lastName1 = person1.getLastName();
		String lastName2 = person2.getLastName();
		return lastName1.compareTo(lastName2);
	}

}
