
public class Multiplication extends AbstractOperation {

	public Multiplication(int operand1, int operand2) {
		super(operand1, operand2);
	}

	@Override
	public int execute() {
		return operand1 * operand2;
	}

	@Override
	public String getName() {
		return "szorzás";
	}

}
