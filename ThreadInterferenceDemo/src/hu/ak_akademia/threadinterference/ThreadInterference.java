package hu.ak_akademia.threadinterference;

public class ThreadInterference {

	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();
		Runnable incrementerTask = new IncrementerTask(counter);
		Runnable decrementerTask = new DecrementerTask(counter);
		Thread incrementerThread = new Thread(incrementerTask);
		Thread decrementerThread = new Thread(decrementerTask);
		incrementerThread.start();
		decrementerThread.start();
		incrementerThread.join();
		decrementerThread.join();
		System.out.println("A counter értéke: " + counter.getValue());
	}

}
