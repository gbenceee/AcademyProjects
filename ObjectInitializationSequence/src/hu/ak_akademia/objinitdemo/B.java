package hu.ak_akademia.objinitdemo;

public class B extends A {
	static {
		System.out.println("B 1. statikus inicializátora fut");
	}

	{
		System.out.println("B 1. példány inicializátora fut");
	}

	public B() {
		System.out.println("B konstroktora fut");
	}

	{
		System.out.println("B 2. példány inicializátora fut");
	}

	static {
		System.out.println("B 2. statikus inicializátora fut");
	}
}
