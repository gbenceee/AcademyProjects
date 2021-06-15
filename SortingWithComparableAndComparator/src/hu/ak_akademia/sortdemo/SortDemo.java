package hu.ak_akademia.sortdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortDemo {

	public static void main(String[] args) {
		List<String> fruits = new ArrayList<>();
		fruits.add("kivi");
		fruits.add("alma");
		fruits.add("körte");
		fruits.add("szőlő");
		fruits.add("szilva");
		fruits.add("barack");
		fruits.add("dinnye");

		System.out.println("aktuális elem sorrend:");
		System.out.println(fruits);
		System.out.println("------");
		System.out.println("megfordítás utáni elem sorrend: ");
		Collections.reverse(fruits);
		System.out.println(fruits);
		System.out.println("------");
		System.out.println("abc sorrend lexikografikus sorrend: ");
		Collections.sort(fruits);
		System.out.println(fruits);
		System.out.println("------");

		System.out.println("lista elemeinek összekeverése: ");
		Collections.shuffle(fruits);
		System.out.println(fruits);
		System.out.println("------");

		System.out.println("fordított abc sorrend fordított lexikografikus sorrend: ");
		Collections.sort(fruits, Collections.reverseOrder());
		System.out.println(fruits);
		System.out.println("------");
		
		
		Collections.shuffle(fruits);
		System.out.println("Szóhossz alapján növekvő sorrend: ");
		System.out.println(fruits);
		Collections.sort(fruits, new StringLengthComparator());
		System.out.println(fruits);
		
		Collections.shuffle(fruits);
		System.out.println("Szóhossz alapján csökkenő sorrend: ");
		System.out.println(fruits);
		Collections.sort(fruits, new StringLengthComparator().reversed());
		System.out.println(fruits);
	}

}
