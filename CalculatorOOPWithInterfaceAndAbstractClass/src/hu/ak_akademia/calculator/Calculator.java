package hu.ak_akademia.calculator;

public class Calculator {

	public static void main(String[] args) {
		Addition addition = new Addition(50, 10);
		int result = addition.execute();
		System.out.println(result);
		System.out.println(addition.getName());

		Operation operation;

		operation = new Addition(50, 10);
		doThisCalculationAndPrintItsResult(operation);

		operation = new Subtraction(50, 10);
		doThisCalculationAndPrintItsResult(operation);

		operation = new Multiplication(50, 10);
		doThisCalculationAndPrintItsResult(operation);

		operation = new Division(50, 10);
		doThisCalculationAndPrintItsResult(operation);
	}

	static void doThisCalculationAndPrintItsResult(Operation operation) {
		int result = operation.execute();
		System.out.println("A(z) " + operation.getName() + " eredménye: " + result);
	}

}
