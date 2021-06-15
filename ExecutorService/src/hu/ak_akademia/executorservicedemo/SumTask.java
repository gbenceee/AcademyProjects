package hu.ak_akademia.executorservicedemo;

import java.util.concurrent.Callable;

public class SumTask implements Callable<Result> {
	private final Long fromInclusive;
	private final Long toExclusive;

	public SumTask(Long fromInclusive, Long toExclusive) {
		this.fromInclusive = fromInclusive;
		this.toExclusive = toExclusive;
	}

	@Override
	public Result call() throws Exception {
		Long sum = 0L;
		for (Long number = fromInclusive; number < toExclusive; number++) {
			sum += number;
		}
		return new Result(fromInclusive, toExclusive, sum);
	}
}
