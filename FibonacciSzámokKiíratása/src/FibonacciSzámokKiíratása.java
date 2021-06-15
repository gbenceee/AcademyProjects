import java.util.Arrays;

public class FibonacciSzámokKiíratása {

	public static void main(String[] args) {
		//Tömb nélkül
		int f1 = 0;
		int f2 = 1;
		int f = 1;
		System.out.println("0: " + f1);
		System.out.println("1: " + f2);
		for(int i = 2; i < 20; i++)
		{
			System.out.println(i + ": " + f);
			f1 = f2;
			f2 = f;
			f = f1 + f2;
		}
		System.out.println("");
		//Tömbbel
		int[] fibonacciArray = new int[80];
		fibonacciArray[0] = 0;
		fibonacciArray[1] = 1;
		for(int i = 2; i < 80; i++)
		{
			
			fibonacciArray[i] = fibonacciArray[i - 2] + fibonacciArray[i - 1];
		}
		System.out.println(Arrays.toString(fibonacciArray));
		System.out.println("");
		//Sorszámozva
		for(int i = 0; i < fibonacciArray.length; i++)
		{
			System.out.println(i + ": " + fibonacciArray[i]);
		}
		
		
		
		
		
		
		
	}

}
