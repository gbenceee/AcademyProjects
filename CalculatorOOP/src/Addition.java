
public class Addition extends Operation {
	public Addition(UserInputHandler in) {
		super(in);
	}

	@Override
	public void execute() {
		super.execute();
		double result = first + second;
		System.out.println("Az összeg: " + result);
	}
}
