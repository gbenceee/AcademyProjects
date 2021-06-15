package hu.ak_akademia.számosztóinakmegállapítása;

import java.util.Iterator;
import java.util.Set;

public class ResultPrinter {
	private Set<Long> divisors;

	public ResultPrinter(Set<Long> divisors) {
		this.divisors = divisors;
	}

	public void printResult() {
		Iterator<Long> iterate = divisors.iterator();
		while (iterate.hasNext()) {
			System.out.println(iterate.next());
		}
	}

}