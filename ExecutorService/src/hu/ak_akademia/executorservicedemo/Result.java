package hu.ak_akademia.executorservicedemo;

public class Result {
	private final long from;
	private final long to;
	private final long sum;

	public Result(long from, long to, long sum) {
		this.from = from;
		this.to = to;
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "[" + from + " - " + to + "] = " + sum;
	}
}
