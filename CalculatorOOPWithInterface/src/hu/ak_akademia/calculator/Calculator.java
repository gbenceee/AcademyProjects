package hu.ak_akademia.calculator;

public class Calculator {

	public static void main(String[] args) {
		Addition addition = new Addition();
		int result = addition.execute(1, 2);
		System.out.println(result);
		System.out.println(addition.getName());
		Operation operation;
		operation = new Addition();
		doThisCalculationAndPrintItsResult(operation, 50, 10);

		operation = new Subtraction();
		doThisCalculationAndPrintItsResult(operation, 50, 10);

		operation = new Multiplication();
		doThisCalculationAndPrintItsResult(operation, 50, 10);

		operation = new Division();
		doThisCalculationAndPrintItsResult(operation, 50, 10);

	}

	static void doThisCalculationAndPrintItsResult(Operation operation, int operand1, int operand2) {
		int result = operation.execute(operand1, operand2);
		System.out.println("A(z) " + operation.getName() + " eredménye: " + result);
	}

}
