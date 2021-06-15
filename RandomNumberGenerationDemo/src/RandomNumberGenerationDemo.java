import java.util.Arrays;
import java.util.Random;

public class RandomNumberGenerationDemo {

	public static void main(String[] args) {
		Random random = new Random();
		int number = random.nextInt(100);
		System.out.println(number);
		System.out.println("--------------------------------------------------------");
		int[] randomArray = new int [10];
		for(int i = 0; i < randomArray.length; i++)
		{
			randomArray[i] = random.nextInt(100);
		}
		System.out.println(Arrays.toString(randomArray));
		System.out.println("--------------------------------------------------------");
		int i = 0;
		while(i < randomArray.length)
		{
			randomArray[i] = random.nextInt(100);
			i++;
		}
		System.out.println(Arrays.toString(randomArray));
		
		
		
		
		
		

	}

}
