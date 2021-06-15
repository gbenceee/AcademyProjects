package hu.ak_akademia.számosztóinakmegállapítása;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class DivisorCalculator extends RecursiveTask<Set<Long>> {
	private static final long serialVersionUID = 1L;
	private long upperBound;
	private long lowerBound;
	private long numberFromUser;

	public DivisorCalculator(long lowerBound, long upperBound, long numberFromUser) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		this.numberFromUser = numberFromUser;
	}

	public DivisorCalculator(long numberFromUser) {
		this(2L, (numberFromUser / 2L) + 1L, numberFromUser);
	}

	@Override
	protected Set<Long> compute() {
		if (isTaskSmall(upperBound)) {
			return calculateDivisors();
		} else {
			long middle = (lowerBound + upperBound) / 2;
			DivisorCalculator task1 = new DivisorCalculator(lowerBound, middle, numberFromUser);
			DivisorCalculator task2 = new DivisorCalculator(middle, upperBound, numberFromUser);
			ForkJoinTask.invokeAll(List.of(task1, task2));
			Set<Long> divisors = new TreeSet<>();
			try {
				divisors.addAll(task1.get());
				divisors.addAll(task2.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			return divisors;
		}
	}

	private Set<Long> calculateDivisors() {
		Set<Long> divisors = new TreeSet<>();
		for (long possibleDivisor = lowerBound; possibleDivisor < upperBound; possibleDivisor++) {
			if (numberFromUser % possibleDivisor == 0) {
				divisors.add(possibleDivisor);
			}
		}
		return divisors;
	}

	private boolean isTaskSmall(long upperBound) {
		return upperBound - lowerBound < 300_000_000;
	}

}