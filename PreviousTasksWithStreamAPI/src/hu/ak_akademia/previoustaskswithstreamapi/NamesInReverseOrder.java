package hu.ak_akademia.previoustaskswithstreamapi;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NamesInReverseOrder {

	public static void main(String[] args) {
// 		MyList<String> names2 = MyList.of("John", "Adam", "Baxter", "Smith");
//      MyList<String> names3 = new MyArrayList<>();
//      names3.addNew("Hello");
//      names3.method1(1);
//      names3.method2(1, 2);
//      names3.method3();
//      names3.method4();
		List<String> names = List.of("John", "Adam", "Baxter", "Smith", "Gordon", "Xan", "George");
		names = names.stream()
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toUnmodifiableList());
		System.out.println(names);
//      TreeMap<String, String> map = names.stream()
//              .sorted(Comparator.reverseOrder())
//              .collect(Collectors.toMap(name -> name.substring(0, 1), Function.identity(), (name1, name2) -> name1 + ", " + name2, TreeMap::new));
//      System.out.println(map);
	}

}
