package hu.ak_akademia.task1;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDataStructureFiller {
	private Random random;

	public TreeSetDataStructureFiller(Random random) {
		this.random = random;
	}

	public Set<Integer> fillWithLotteryNumbers() {
		Set<Integer> set = new TreeSet<>();
		while (set.size() < 5) {
			set.add(random.nextInt(90) + 1);
		}
		return set;
	}
}
