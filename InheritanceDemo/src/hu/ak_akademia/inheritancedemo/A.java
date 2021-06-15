package hu.ak_akademia.inheritancedemo;

public class A {

	int a = 10; // példány változó
	static int A = 100; // osztály változó

	// példány metódus
	void m1() {
		System.out.println("A példány metódusa");
	}

	// osztály metódus
	static void m2() {
		System.out.println("A osztály metódusa");
	}

}
