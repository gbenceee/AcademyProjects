package hu.ak_akademia.prímszámokkiszámítása;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class PrimeNumberCollector {
	public Set<Long> collectPrimeNumbersLesserThanSpecifiedNumber(long specifiedNumber) {
		return collectPrimeNumbersWithinInterval(2, specifiedNumber);
	}

	public Set<Long> collectPrimeNumbersWithinInterval(long beginningNumberOfInterval, long endNumberOfInterval) {
		Set<Long> primeNumbers = Collections.synchronizedSet(new HashSet<>());
		nextIteration: for (long dividend = beginningNumberOfInterval; dividend <= endNumberOfInterval; dividend++) {
			for (long divisor = 2; divisor <= Math.sqrt(dividend); divisor++) {
				if (dividend % divisor == 0) {
					continue nextIteration;
				}
			}
			primeNumbers.add(dividend);
		}
		return primeNumbers;
	}
}