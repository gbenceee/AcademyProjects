package hu.ak_akademia.sortedsetdemo;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo {

	public static void main(String[] args) {
		SortedSet<String> names = new TreeSet<>();
		names.add("Béla");
		names.add("Aladár");
		names.add("Dezső");
		names.add("Zsolt");
		names.add("Péter");
		names.add("Gergő");
		names.add("Ferenc");
		names.add("Ildikó");
		names.add("Borbála");
		names.add("Eszter");
		names.add("Hedvig");
		System.out.println(names);

		SortedSet<String> headSet = names.headSet("Hedvig");
		System.out.println(headSet);

		SortedSet<String> tailSet = names.tailSet("Ferenc");
		System.out.println(tailSet);

		SortedSet<String> subSet = names.subSet("Ferenc", "Hedvig");
		System.out.println(subSet);

		headSet.add("Bence");
		headSet.add("Dalma");
		headSet.remove("Eszter");
//		headSet.add("Zoli"); nem lehet mert Zoli a tartományon kívül esik (Hedvig a tartomány határa)
		System.out.println("Eredeti halmaz: " + names);
		System.out.println("Rész halmaz: " + headSet);

		names.add("Fiona");
		System.out.println("Eredeti halmaz: " + names);
		System.out.println("Rész halmaz: " + headSet);
		
		names.add("Zoli");
		System.out.println("Eredeti halmaz: " + names);
		System.out.println("Rész halmaz: " + headSet);
		
		names.remove("Béla");
		System.out.println("Eredeti halmaz: " + names);
		System.out.println("Rész halmaz: " + headSet);

	}

}
