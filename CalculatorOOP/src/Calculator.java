import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		new Calculator().run();

	}

	private void run() {
		Scanner scan = new Scanner(System.in);
		UserInputHandler userInputHandler = new UserInputHandler(scan);
		Menu menu = new Menu(userInputHandler);
		loop: do {
			menu.print();
			int chosenMenuOption = menu.chooseMenuOption();
			Operation operation = null;

			switch (chosenMenuOption) {
			case 1:
				operation = new Addition(userInputHandler);
				break;
			case 2:
				operation = new Subtraction(userInputHandler);
				break;
			case 3:
				operation = new Multiplication(userInputHandler);
				break;
			case 4:
				operation = new Division(userInputHandler);
				break;
			case 5:
				System.out.println("kilépés");
				break loop;
			}
			operation.execute();
		} while (true);
		scan.close();
	}
}
