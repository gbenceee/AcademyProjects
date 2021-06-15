package hu.ak_akademia.threaddemo;

import java.util.Random;

public class Consumer implements Runnable {

	private Drop drop;

	public Consumer(Drop drop) {
		this.drop = drop;
	}

	public void run() {
		Random random = new Random();
		try {
			for (String message = drop.take(); !message.equals("DONE"); message = drop.take()) {
				System.out.format("MESSAGE RECEIVED: %s%n", message);
				Thread.sleep(random.nextInt(5_000));
			}
		} catch (InterruptedException e) {
			System.out.println("The consumer has been interrupted.");
		}
	}
}
