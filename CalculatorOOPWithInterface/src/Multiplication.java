
public class Multiplication implements Operation {

	@Override
	public int execute(int a, int b) {
		return a * b;
	}
	@Override
	public String getName() {
		return "szorzás";
	}

}
