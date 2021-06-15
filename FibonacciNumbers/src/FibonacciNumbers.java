public class FibonacciNumbers {

	public static void main(String[] args) {
		// 0 1 1 2 3 5 8 13
		int f2 = 0;
		int f1 = 1;
		System.out.println("1. 0");
		System.out.println("2. 1");
		for (int i = 3; i <= 20; i++) {
			int f = f2 + f1;
			System.out.println(i + ". " + f);
			f2 = f1;
			f1 = f;
		}
	}

}