
public class OperatorDemo {

	public static void main(String[] args) {
		int x = 10;
		int y = 7;
		int z = ++x * y++ + 5;
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		System.out.println("z = " + z);
		System.out.println("---------");
		
		int a = x / 3;
		int b = x % 3;
		System.out.println(a);
		System.out.println(b);
		System.out.println("---------");
		
		double c = 5.0 / 2.0;
		System.out.println(c);
		
		double d = 5 / 2;
		System.out.println(d);
		System.out.println("---------");
		
		
		boolean e = x <= y + 3;		// true
		System.out.println(e);
		System.out.println("---------");
		
		//a&&b ha mindkét feltétel true akkor true, egyébként false
		//a||b ha legalább az egyik feltétel true akkor true, egyébként false
		//a^b ha csak az egyik feltétel true akkor true, egyébként false
		
		boolean f = false;			// false
		
		boolean g = !e; 			// false
		boolean h = e || f && g;	// h = true || false && false
		System.out.println(h);
		
		
		
		
		
		
		
		
		

	}

}
