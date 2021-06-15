package hu.ak_akademia.calculator;

public class Subtraction implements Operation {

	@Override
	public int execute(int a, int b) {
		return a - b;
	}
	@Override
	public String getName() {
		return "kivonás";
	}
}
