
public class StringBuilderDemo {

	public static void main(String[] args) {
		
		StringBuilder str = new StringBuilder("Hello");
		System.out.println(str);
		//str.append();
		System.out.println(str);
		System.out.println(str.capacity());
		System.out.println(str.indexOf("l"));
		System.out.println(str.replace(1, 3, "World"));
	}

}
