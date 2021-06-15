package hu.ak_akademia.sublistdemo;

import java.util.ArrayList;
import java.util.List;

public class SubListDemo {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("Botond");
		names.add("István");
		names.add("Dóra");
		names.add("Vladimir");
		names.add("Gergő");
		names.add("Bence");
		names.add("Andris");
		System.out.println(names);

		List<String> subList = names.subList(2, 5);
		System.out.println(subList);

		subList.add("Csongor");
		System.out.println(names);
		System.out.println(subList);

		subList.remove(1);
		System.out.println(names);
		System.out.println(subList);
		// amit a sublisttel csinálunk, az eredeti listára is hatással van
		List<String> myNewIndependentList = new ArrayList<>(subList);
		System.out.println(myNewIndependentList);

		names.add(4, "Szabolcs");
		System.out.println(names);
		System.out.println(subList);
	}

}
