package hu.ak_akademia.threadinterference;

public class DecrementerTask implements Runnable {
	private Counter counter;

	public DecrementerTask(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1_000_000; i++) {
			counter.decrement();
		}
	}

}
