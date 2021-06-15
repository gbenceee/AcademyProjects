public class ControlFlowStatementsDemo {

	public static void main(String[] args) {
		int number = 1763;
		if (number > 1000) {
			System.out.println("A szám nagyobb, mint 1000.");
		} else if (number < 1000) {
			System.out.println("A szám kisebb mint 1000.");
		} else {
			System.out.println("A szám pont 1000.");
		}

		System.out.println("A szám kisebb vagy egyenlő 1000-rel.");

		int dayOfWeek = 3;
		if (dayOfWeek == 1) {
			System.out.println("Hétfő");
		} else if (dayOfWeek == 2) {
			System.out.println("Kedd");
		} else if (dayOfWeek == 3) {
			System.out.println("Szerda");
		} else if (dayOfWeek == 4) {
			System.out.println("Csütörtök");
		} else if (dayOfWeek == 5) {
			System.out.println("Péntek");
		} else if (dayOfWeek == 6) {
			System.out.println("Szombat");
		} else if (dayOfWeek == 7) {
			System.out.println("Vasárnap");
		} else {
			System.out.println("Ismeretlen nap.");
		}

		switch (dayOfWeek) {
		case 1:
			System.out.println("Hétfő");
			break;
		case 2:
			System.out.println("Kedd");
			break;
		case 3:
			System.out.println("Szerda");
			break;
		case 4:
			System.out.println("Csütörtök");
			break;
		case 5:
			System.out.println("Péntek");
			break;
		case 6:
			System.out.println("Szombat");
			break;
		case 7:
			System.out.println("Vasárnap");
			break;
		default:
			System.out.println("Ismeretlen nap.");
			break;
		}
		System.out.println("Program vége.");

	}

}
