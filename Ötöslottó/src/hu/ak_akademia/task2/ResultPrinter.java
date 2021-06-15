package hu.ak_akademia.task2;

import java.util.Set;

public class ResultPrinter {
	public void printResult(Set<Integer> numbersFromUser, ResultCounter counter, Set<Integer> lotteryNumbers) {
		System.out.println("A feladott számok: " + numbersFromUser);
		System.out.println("A nyerő számok: " + lotteryNumbers);
		System.out.println("Sorsolások: " + counter.getDrawsUntilFive());
		System.out.println("Egyes találatok: " + counter.getNumberOfOnesUntilFive());
		System.out.println("Kettes találatok: " + counter.getNumberOfTwosUntilFive());
		System.out.println("Hármas találatok: " + counter.getNumberOfThreesUntilFive());
		System.out.println("Négyes találatok: " + counter.getNumberOfFoursUntilFive());
	}
}
