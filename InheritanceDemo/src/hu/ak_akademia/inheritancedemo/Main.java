package hu.ak_akademia.inheritancedemo;

public class Main {

	public static void main(String[] args) {
		A o1 = new A();
		System.out.println(o1.a);
		System.out.println(o1.A);
		o1.m1();
		o1.m2();

		System.out.println("-------------");

		B o2 = new B();
		System.out.println(o2.a);
		System.out.println(o2.A);
		o2.m1();
		o2.m2();

		System.out.println("-------------");

		A o3 = new B();
		System.out.println(o3.a);
		System.out.println(o3.A);
		o3.m1();
		o3.m2();

		System.out.println("-------------");

		System.out.println(o3.a);
		System.out.println(((B) o3).a);

		System.out.println("-------------");

		B o4 = new B();
		o4.m2();
		
		System.out.println("-------------");
		
		B o5 = new B();
		System.out.println(o5.a);
		
		

	}

}
