package hu.ak_akademnia.lambdaexpressions;

public class ExponentiationOperation implements Operation {
	@Override
	public int execute(int a, int b) {
		int result = 1;
		for (int i = 0; i < b; i++) {
			result *= a;
		}
		return result;
	}
}
