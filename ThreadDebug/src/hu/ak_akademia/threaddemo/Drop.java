package hu.ak_akademia.threaddemo;

public class Drop {
	private String message;
	private boolean empty = true;

	public synchronized String take() throws InterruptedException {
		while (empty) {
			wait();
		}
		empty = true;
		notifyAll();
		return message;
	}

	public synchronized void put(String message) throws InterruptedException {
		while (!empty) {
			wait();
		}
		empty = false;
		this.message = message;
		notifyAll();
	}
}
