package hu.ak_akademia.inheritancedemo;

public class B extends A {

	int a = 20; // példány változó
	static int A = 200; // osztály változó

	// példány metódus
	void m1() {
		System.out.println("B példány metódusa");
	}

	// osztály metódus
	static void m2() {
		System.out.println("B osztály metódusa");
	}
}
