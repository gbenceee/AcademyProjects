public class printNumbers {

	public static void main(String[] args) {
		
		for(int i = 0; i <= 30; i++)
		{
				if(i % 2 ==0)
				{
					System.out.println(i);
				}
			
		}
		
		
		System.out.println("");
		
		
		for(int i = 30; i >= 0; i--)
		{
				System.out.println(i);
			
		}
		
		System.out.println("");
		
		for(int i = 50; i < 100; i++)
		{
				if(i % 2 == 1)
				{
					System.out.println(i);
				}
		}
		
		System.out.println("");
		
		for(int i = 2; i <= 1024; i*=2)
		{
			System.out.println(i);
			
		}
		System.out.println("");
		//Fibonacci NOK
		int[] fibonacci = {0, 1, 1 ,2 ,3, 5, 8, 13, 21, 30, 39, 69, 108, 177, 285, 452, 737, 1189, 1926, 3115};
		for(int i = 0; i < 20; i++)
		{
			System.out.println(fibonacci[i]);
		}
		//Megoldás
		int f2 = 0;
		int f1 = 1;
		System.out.println("1. 0");
		System.out.println("2. 1");
		for(int i = 3; i <= 20; i++)
		{
			int f = f2 + f1;
			System.out.println(i +". " + f);
			f2 = f1;
			f1 = f;
		}
		
		
		
		
		
		
		

	}

}

