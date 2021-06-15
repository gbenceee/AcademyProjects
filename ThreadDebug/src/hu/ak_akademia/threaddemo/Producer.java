package hu.ak_akademia.threaddemo;

import java.util.List;
import java.util.Random;

public class Producer implements Runnable {
	private Drop drop;

	public Producer(Drop drop) {
		this.drop = drop;
	}

	public void run() {
		try {
			List<String> messages = List.of("First message.", "Second message.", "Third message.", "Fourth message.", "Fifth message.", "Sixth message.", "Seventh message.");
			Random random = new Random();

			for (String message : messages) {
				drop.put(message);
				Thread.sleep(random.nextInt(5_000));
			}
			drop.put("DONE");
		} catch (InterruptedException e) {
			System.out.println("The producer has been interrupted.");
		}
	}
}
