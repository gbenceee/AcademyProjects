package hu.ak_akademia.számosztóinakmegállapítása;

import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;

public class Main {

	public static void main(String[] args) {
		long numberFromUser;
		try (Scanner scan = new Scanner(System.in)) {
			numberFromUser = new UserInputHandler(scan).scanCorrectNumberFromUser();
		}
		ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
		DivisorCalculator calculate = new DivisorCalculator(numberFromUser);
		Set<Long> divisorsOfNumberFromUser = forkJoinPool.invoke(calculate);
		divisorsOfNumberFromUser.add(1L);
		divisorsOfNumberFromUser.add(numberFromUser);
		new ResultPrinter(divisorsOfNumberFromUser).printResult();
	}
}