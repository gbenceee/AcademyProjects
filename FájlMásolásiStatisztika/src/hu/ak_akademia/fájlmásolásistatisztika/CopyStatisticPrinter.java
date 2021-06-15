package hu.ak_akademia.fájlmásolásistatisztika;

import java.util.Map;

public class CopyStatisticPrinter {
	private Map<Integer, Long> statistic;

	public CopyStatisticPrinter(Map<Integer, Long> statistic) {
		this.statistic = statistic;
	}

	public void printCopyStatisticInAscendingOrderByValue() {
		statistic
				.entrySet().stream().sorted(Map.Entry.comparingByValue()).map(element -> "Eltelt nanoszekundum: "
						+ element.getValue() + ", használt pufferméret: " + element.getKey())
				.forEach(System.out::println);
	}
}
