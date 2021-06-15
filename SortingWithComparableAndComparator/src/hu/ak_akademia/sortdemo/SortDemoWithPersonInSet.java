package hu.ak_akademia.sortdemo;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class SortDemoWithPersonInSet {

	public static void main(String[] args) {
		Person person1 = new Person("Elek", "Teszt", 12);
		Person person2 = new Person("Zoltán", "Kovács", 44);
		Person person3 = new Person("Áron", "Szabó", 8);
		Person person4 = new Person("Károly", "Tóth", 30);
		Person person5 = new Person("Hedvig", "Kis", 28);
		Person person6 = new Person("Ágnes", "Nagy", 58);
		Person person7 = new Person("Zsófia", "Hosszú", 18);

		Set<Person> people = new TreeSet<>();
//		Set<Person> people = new TreeSet<>(new AgeComparator());
//		Set<Person> people = new TreeSet<>(new LastNameComparator());
//		Set<Person> people = new TreeSet<>(new FullPersonComparator());
		people.add(person1);
		people.add(person2);
		people.add(person3);
		people.add(person4);
		people.add(person5);
		people.add(person6);
		people.add(person7);
		System.out.println("Eredeti sorrend: ");
		System.out.println(people);

	}
}
