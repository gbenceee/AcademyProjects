package hu.ak_akademia.objinitdemo;

public class A {
	static {
		System.out.println("A 1. statikus inicializátora fut");
	}

	{
		System.out.println("A 1. példány inicializátora fut");
	}

	public A() {
		System.out.println("A konstroktora fut");
	}

	{
		System.out.println("A 2. példány inicializátora fut");
	}

	static {
		System.out.println("A 2. statikus inicializátora fut");
	}
}
