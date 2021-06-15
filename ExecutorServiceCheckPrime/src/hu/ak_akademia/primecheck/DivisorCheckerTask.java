package hu.ak_akademia.primecheck;

import java.util.concurrent.Callable;

public class DivisorCheckerTask implements Callable<Result> {

	private final long numberToCheck;
	private final long fromInclusive;
	private final long toExclusive;

	public DivisorCheckerTask(long numberToCheck, long fromInclusive, long toExclusive) {
		this.numberToCheck = numberToCheck;
		this.fromInclusive = fromInclusive;
		this.toExclusive = toExclusive;
	}

	@Override
	public Result call() throws Exception {
		Result result = Result.HAS_NO_DIVISOR;
		for (long possibleDivisor = fromInclusive; possibleDivisor < toExclusive; possibleDivisor++) {
			if (numberToCheck % possibleDivisor == 0) {
				result = Result.HAS_DIVISOR;
			}
		}
		return result;
	}
}
