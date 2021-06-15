package hu.ak_akademia.threadinterference;

public class Counter {
	private int counter = 0;


	public synchronized void increment() {
		counter++;
	}
	public synchronized void decrement() {
		counter--;
	}
	public int getValue() {
		return counter;
	}
	

}
