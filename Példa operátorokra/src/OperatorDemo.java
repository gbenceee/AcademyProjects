
public class OperatorDemo {

	public static void main(String[] args) {
		// & <- and operator
		// && <- short circuiting and operation
		int counter = 0;
		int a = 7;
		int b = 10;
		int i = 1;
		i = i++ + ++i;
		System.out.println(i);
		if (counter++ < 100 & counter++ < 200 && b < a && counter++ < 300) {
			System.out.println("Igaz. Counter: " + counter);
		} else {
			System.out.println("Hamis. Counter: " + counter);
		}
	}

}
