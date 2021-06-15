import java.util.Scanner;

public class UserInputDemo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Kérlek, adj meg egy egész számot: ");
		int number = scanner.nextInt();
		scanner.nextLine();
		System.out.println("Ezt a számot adtad meg: " + number);
		System.out.println("---------------------------------------");
		System.out.println("Adj meg egy számot!");
		int yourNumber = scanner.nextInt();
		scanner.nextLine();
		scanner.close();
		System.out.println("---------------------------------------");
		for(int i = 0; i <= yourNumber; i++)
		{
			System.out.println(i);
		}
		System.out.println("---------------------------------------");
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
