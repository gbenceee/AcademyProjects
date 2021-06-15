package hu.ak_akademia.task2;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import hu.ak_akademia.task1.TreeSetDataStructureFiller;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		TreeSetDataStructureFiller fill = new TreeSetDataStructureFiller(random);
		Set<Integer> numbersFromUser = new UserInputHandler(scan).getCorrectLotteryNumbers();
		scan.close();
		ResultCounter counter = new ResultCounter();
		ResultChecker check = new ResultChecker();
		Set<Integer> lotteryNumbers = new TreeSet<>();
		Set<Integer> result = new TreeSet<>();
		lotteryNumbers = drawUntilWin(fill, numbersFromUser, counter, check, result);
		new ResultPrinter().printResult(numbersFromUser, counter, lotteryNumbers);
	}

	private static Set<Integer> drawUntilWin(TreeSetDataStructureFiller fill, Set<Integer> numbersFromUser, ResultCounter counter, ResultChecker check, Set<Integer> result) {
		Set<Integer> lotteryNumbers;
		do {
			lotteryNumbers = fill.fillWithLotteryNumbers();
			if (!check.isWin(lotteryNumbers, numbersFromUser)) {
				counter.setDrawsUntilFive(counter.getDrawsUntilFive() + 1);
			} else {
				break;
			}
			result.addAll(numbersFromUser);
			result.retainAll(lotteryNumbers);
			counter.countResult(result);
		} while (!check.isWin(lotteryNumbers, numbersFromUser));
		return lotteryNumbers;
	}

}
