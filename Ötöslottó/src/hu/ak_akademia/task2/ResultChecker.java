package hu.ak_akademia.task2;

import java.util.Set;

public class ResultChecker {
	public boolean isWin(Set<Integer> lotteryNumbers, Set<Integer> numbersFromUser) {
		return lotteryNumbers.containsAll(numbersFromUser);
	}
}
