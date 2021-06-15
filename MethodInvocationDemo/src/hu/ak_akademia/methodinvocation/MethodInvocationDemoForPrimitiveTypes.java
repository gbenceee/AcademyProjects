package hu.ak_akademia.methodinvocation;

public class MethodInvocationDemoForPrimitiveTypes {

	public static void main(String[] args) {
		int i = 14;
		System.out.println(i);
		execute(i); // pass by value
		System.out.println(i);
	}

	private static void execute(int j) {
		j = 20;
	}

}
