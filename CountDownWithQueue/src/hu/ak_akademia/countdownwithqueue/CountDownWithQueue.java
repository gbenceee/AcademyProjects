package hu.ak_akademia.countdownwithqueue;

import java.util.LinkedList;
import java.util.Queue;

public class CountDownWithQueue {

	public static void main(String[] args) throws InterruptedException {
		int start = Integer.parseInt(args[0]);
		Queue<Integer> second = new LinkedList<Integer>();
		for (int i = start; i >= 0; i--) {
			second.add(i);
		}
		while (!second.isEmpty()) {
			int number = second.remove();
			Thread.sleep(1000);
			System.out.println(number + " másodperc van hátra.");
		}
		System.out.println("A program leállt.");
	}

}
