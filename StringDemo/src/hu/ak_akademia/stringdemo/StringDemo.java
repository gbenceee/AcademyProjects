package hu.ak_akademia.stringdemo;

public class StringDemo {

	public static void main(String[] args) {
		String a;
		String b = new String();
		String c = null;
		String d = "";
		// String e1 = "alma";
		// String e2 = new String(new char[] { 'a', 'l', 'm', 'a' });

		a = "alma";
		System.out.println(a);
		System.out.println(b.length());
		System.out.println(c);
		c = "Körte";
		System.out.println(c.toLowerCase());
		System.out.println(d.length());
		System.out.println(b.equals(d));
		c = null;
		System.out.println(b.equals(c));
		if (c != null) {
			System.out.println(c.equals(b));
		}
	}
}
