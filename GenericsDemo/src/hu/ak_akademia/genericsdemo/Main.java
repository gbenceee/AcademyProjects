package hu.ak_akademia.genericsdemo;

public class Main {

	public static void main(String[] args) {
		Box<Integer> integerBox = new Box<>();
		System.out.println(integerBox);
		integerBox.put(42);
		System.out.println(integerBox);
		// numberBox.put(72);
		Integer contentOfTheBox = integerBox.get();
		System.out.println(contentOfTheBox);
		System.out.println(integerBox);

		Box<String> stringBox = new Box<>();
		stringBox.put("this is some text");
		// textBox.put(45);
		System.out.println(stringBox);

		// raw type - ne használjuk!
		Box mysticBox = new Box();
		mysticBox.put("Lorem ipsum");
		System.out.println(mysticBox);
		mysticBox.get();
		mysticBox.put(145);
		System.out.println(mysticBox);

		integerBox.put(72);
		Box<Long> longBox = new Box<>();
		longBox.put(3_000_000_000_000L);
		Box<Double> doubleBox = new Box<>();
		doubleBox.put(3.1415);
		Box<Number> numberBox = new Box<>();

		calculate(numberBox);
		calculate(integerBox);
		calculate(longBox);
		calculate(doubleBox);
		calculate(stringBox);

		doSomething(numberBox);
		doSomething(integerBox);
		doSomething(longBox);
		doSomething(doubleBox);
		doSomething(stringBox);

		doSomethingElse(numberBox);
		doSomethingElse(integerBox);
		doSomethingElse(longBox);
		doSomethingElse(doubleBox);
		doSomethingElse(stringBox);
	}

	private static void calculate(Box<? extends Number> box) {
		Number numberContent = box.get();
		System.out.println(numberContent);
	}

	private static void doSomething(Box<? super Integer> box) {
		System.out.println(box);
	}

	private static void doSomethingElse(Box<?> box) {
		System.out.println(box);
	}

}
