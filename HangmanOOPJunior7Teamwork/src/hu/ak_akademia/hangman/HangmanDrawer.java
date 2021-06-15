package hu.ak_akademia.hangman;

public class HangmanDrawer {
	public void printHangman(int number) {
		switch (number) {
		case 1:
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("────┷─────────");
			break;
		case 2:
			System.out.println("    ┌");
			System.out.println("    │");
			System.out.println("    │");
			System.out.println("    │");
			System.out.println("    │");
			System.out.println("    │");
			System.out.println("    │");
			System.out.println("────┷─────────");
			break;
		case 3:
			System.out.println("    ┌────┐    ");
			System.out.println("    │  ");
			System.out.println("    │  ");
			System.out.println("    │  ");
			System.out.println("    │  ");
			System.out.println("    │  ");
			System.out.println("    │  ");
			System.out.println("────┷─────────");
			break;
		case 4:
			System.out.println("    ┌────┐    ");
			System.out.println("    │    │    ");
			System.out.println("    │    ");
			System.out.println("    │    ");
			System.out.println("    │    ");
			System.out.println("    │    ");
			System.out.println("    │    ");
			System.out.println("────┷─────────");
			break;
		case 5:
			System.out.println("    ┌────┐    ");
			System.out.println("    │    │    ");
			System.out.println("    │    O    ");
			System.out.println("    │   ");
			System.out.println("    │   ");
			System.out.println("    │   ");
			System.out.println("    │   ");
			System.out.println("────┷─────────");
			break;
		case 6:
			System.out.println("    ┌────┐    ");
			System.out.println("    │    │    ");
			System.out.println("    │    O    ");
			System.out.println("    │    │   ");
			System.out.println("    │    │    ");
			System.out.println("    │     ");
			System.out.println("    │         ");
			System.out.println("────┷─────────");
			break;
		case 7:
			System.out.println("    ┌────┐    ");
			System.out.println("    │    │    ");
			System.out.println("    │    O    ");
			System.out.println("    │   ╱│   ");
			System.out.println("    │    │    ");
			System.out.println("    │      ");
			System.out.println("    │         ");
			System.out.println("────┷─────────");
			break;
		case 8:
			System.out.println("    ┌────┐    ");
			System.out.println("    │    │    ");
			System.out.println("    │    O    ");
			System.out.println("    │   ╱│╲   ");
			System.out.println("    │    │    ");
			System.out.println("    │     ");
			System.out.println("    │         ");
			System.out.println("────┷─────────");
			break;
		case 9:
			System.out.println("    ┌────┐    ");
			System.out.println("    │    │    ");
			System.out.println("    │    O    ");
			System.out.println("    │   ╱│╲   ");
			System.out.println("    │    │    ");
			System.out.println("    │   ╱    ");
			System.out.println("    │         ");
			System.out.println("────┷─────────");
			break;
		case 10:
			System.out.println("    ┌────┐    ");
			System.out.println("    │    │    ");
			System.out.println("    │    O    ");
			System.out.println("    │   ╱│╲   ");
			System.out.println("    │    │    ");
			System.out.println("    │   ╱ ╲   ");
			System.out.println("    │         ");
			System.out.println("────┷─────────");
			break;

		}
	}
}
