package hu.ak_akademia.sortdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortDemoWithPersonInList {

	public static void main(String[] args) {
		Person person1 = new Person("Elek", "Teszt", 12);
		Person person2 = new Person("Zoltán", "Kovács", 44);
		Person person3 = new Person("Áron", "Szabó", 8);
		Person person4 = new Person("Károly", "Tóth", 30);
		Person person5 = new Person("Hedvig", "Kis", 28);
		Person person6 = new Person("Ágnes", "Nagy", 58);
		Person person7 = new Person("Zsófia", "Hosszú", 18);

		List<Person> people = new ArrayList<>();
		people.add(person1);
		people.add(person2);
		people.add(person3);
		people.add(person4);
		people.add(person5);
		people.add(person6);
		people.add(person7);
		System.out.println("Eredeti sorrend: ");
		System.out.println(people);

		System.out.println("Abc sorrend vezetéknév alapján: ");
		Collections.sort(people, new LastNameComparator());
		System.out.println(people);

		System.out.println("Keverés utáni sorrend: ");
		Collections.shuffle(people);
		System.out.println(people);

		System.out.println("Életkor alapján növekvő sorrend: ");
		Collections.sort(people, new AgeComparator());
		System.out.println(people);

		System.out.println("Keverés utáni sorrend: ");
		Collections.shuffle(people);
		System.out.println(people);

		System.out.println("Életkor alapján csökkenő sorrend: ");
		Collections.sort(people, new AgeComparator().reversed());
		System.out.println(people);
	}
}
