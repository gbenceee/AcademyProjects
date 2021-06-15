package hu.ak_akademia.replacedemo;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		String value = "D";
		List<String> anotherList = new ArrayList<>();
		anotherList.add("1");
		anotherList.add("2");
		anotherList.add("3");
		replace(list, value, anotherList);
		System.out.println(list);
	}

	public static void replace(List<String> list, String val, List<? extends String> newVals) {
		for (ListIterator<String> it = list.listIterator(); it.hasNext();) {
			if (it.next()
					.equals(val)) {
				it.remove();
				for (String s : newVals) {
					it.add(s);
				}
			}
		}
	}
}
