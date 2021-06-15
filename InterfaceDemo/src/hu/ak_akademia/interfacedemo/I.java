package hu.ak_akademia.interfacedemo;

public interface I {

	// fordítás idejű konstansok (alapértelmezés szerint public static final)
	double PI = 3.14;
	public double PI1 = 3.14;
	static double PI2 = 3.14;
	final double PI3 = 3.14;
	public final double PI4 = 3.14;
	final public double PI5 = 3.14;
	static final public double PI6 = 3.14;

	// public abstract metódusok (alapértelmezés szerint public abstract)
	void m1();

	public void m2();

	abstract void m3();

	public abstract void m4();

	abstract public void m5();

	// statikus metódusok (alapértelmezés szerint public)
	static void print(String message) {
		System.out.println(message);
	}

	public static void print2(String message) {
		System.out.println(message);
	}

	// default példány metódusok (alapértelmezés szerint public)
	default int calculate(int a, int b) {
		execute();
		return a + b;
	}

	public default int calculate2(int a, int b) {
		execute();
		return a + b;
	}

	// private példány metódus
	private void execute() {
		// do something
	}

	interface I2 {
	}

	class C {
	}

}
