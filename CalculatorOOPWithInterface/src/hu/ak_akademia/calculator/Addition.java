package hu.ak_akademia.calculator;

public class Addition implements Operation {

	@Override
	public int execute(int a, int b) {
		return a + b;
	}

	@Override
	public String getName() {
		return "összeadás";
	}

}
