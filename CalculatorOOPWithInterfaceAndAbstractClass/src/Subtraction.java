
public class Subtraction extends AbstractOperation {

	public Subtraction(int operand1, int operand2) {
		super(operand1, operand2);
	}

	@Override
	public int execute() {
		return operand1 - operand2;
	}

	@Override
	public String getName() {
		return "kivonás";
	}
}
