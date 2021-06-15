package hu.ak_akademia.methodinvocation;

public class MethodInvocationDemoForReferenceTypes2 {

	public static void main(String[] args) {
		Date myBirthDay = new Date(1984, 11, 6);
		System.out.println(myBirthDay);
		execute(myBirthDay); // pass by value
		System.out.println(myBirthDay);
	}

	private static void execute(Date theDate) {
		theDate = new Date(1983, 1, 1);
	}
}
