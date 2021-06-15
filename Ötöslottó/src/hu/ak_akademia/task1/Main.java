package hu.ak_akademia.task1;

import java.util.Random;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		TreeSetDataStructureFiller fill = new TreeSetDataStructureFiller(rand);
		Set<Integer> lotteryNumbers = fill.fillWithLotteryNumbers();
		System.out.println(lotteryNumbers);

	}

}
