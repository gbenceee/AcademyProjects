package hu.ak_akademia.task2;

import java.util.Set;

public class ResultCounter {
	private int drawsUntilFive = 0;
	private int numberOfFoursUntilFive = 0;
	private int numberOfThreesUntilFive = 0;
	private int numberOfTwosUntilFive = 0;
	private int numberOfOnesUntilFive = 0;

	public int getDrawsUntilFive() {
		return drawsUntilFive;
	}

	public void setDrawsUntilFive(int drawsUntilFive) {
		this.drawsUntilFive = drawsUntilFive;
	}

	public int getNumberOfFoursUntilFive() {
		return numberOfFoursUntilFive;
	}

	public void setNumberOfFoursUntilFive(int numberOfFoursUntilFive) {
		this.numberOfFoursUntilFive = numberOfFoursUntilFive;
	}

	public int getNumberOfThreesUntilFive() {
		return numberOfThreesUntilFive;
	}

	public void setNumberOfThreesUntilFive(int numberOfThreesUntilFive) {
		this.numberOfThreesUntilFive = numberOfThreesUntilFive;
	}

	public int getNumberOfTwosUntilFive() {
		return numberOfTwosUntilFive;
	}

	public void setNumberOfTwosUntilFive(int numberOfTwosUntilFive) {
		this.numberOfTwosUntilFive = numberOfTwosUntilFive;
	}

	public int getNumberOfOnesUntilFive() {
		return numberOfOnesUntilFive;
	}

	public void setNumberOfOnesUntilFive(int numberOfOnesUntilFive) {
		this.numberOfOnesUntilFive = numberOfOnesUntilFive;
	}

	public void countResult(Set<Integer> result) {
		switch (result.size()) {
		case 1:
			this.numberOfOnesUntilFive++;
			break;
		case 2:
			this.numberOfTwosUntilFive++;
			break;
		case 3:
			this.numberOfThreesUntilFive++;
			break;
		case 4:
			this.numberOfFoursUntilFive++;
			break;
		}

	}

}
