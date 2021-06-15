package hu.ak_akademia.threadsafety;

import java.util.Set;

public class PutNumberInSetTask implements Runnable {
	private Set<Integer> numbers;

	public PutNumberInSetTask(Set<Integer> numbers) {
		this.numbers = numbers;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 100_000; i++) {
			numbers.add(i);
		}
	}

}
