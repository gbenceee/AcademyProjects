package hu.ak_akademia.sortdemo;

import java.util.Comparator;

public class FullPersonComparator implements Comparator<Person>{

	@Override
	public int compare(Person person1, Person person2) {
		Comparator<Person> lastNameComparator = new LastNameComparator();
		int lastNameComparisonResult = lastNameComparator.compare(person1, person2);
		if(lastNameComparisonResult == 0) {
			Comparator<Person> ageComparator = new AgeComparator();
			int ageComparisonResult = ageComparator.compare(person1, person2);
			if(ageComparisonResult == 0) {
				return person1.getFirstName().
			}
		}
	}

}
