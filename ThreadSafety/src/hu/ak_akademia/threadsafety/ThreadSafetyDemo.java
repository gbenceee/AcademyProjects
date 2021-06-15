package hu.ak_akademia.threadsafety;

import java.util.LinkedHashSet;
import java.util.Set;

public class ThreadSafetyDemo {

	public static void main(String[] args) throws InterruptedException {
		// megoldható szinkronizációs csomagoló osztállyal
//      Set<Integer> numbers = Collections.synchronizedSet(new LinkedHashSet<>());
		Set<Integer> numbers = new LinkedHashSet<>();
		Runnable task = new PutNumberInSetTask(numbers);
		Thread thread1 = new Thread(task);
		Thread thread2 = new Thread(task);
		Thread thread3 = new Thread(task);
		Thread thread4 = new Thread(task);
		Thread thread5 = new Thread(task);
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread1.join();
		thread2.join();
		thread3.join();
		thread4.join();
		thread5.join();
		System.out.println("A halmaz mérete: " + numbers.size());
		for (Integer number : numbers) {
			System.out.println(number);
		}
	}

}
