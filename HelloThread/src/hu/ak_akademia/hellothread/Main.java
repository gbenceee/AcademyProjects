package hu.ak_akademia.hellothread;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new PrintMessageTask());
		thread.start();
		Thread.sleep(35_000L);
		thread.interrupt();
		System.out.println("Main vége.");
	}

}
