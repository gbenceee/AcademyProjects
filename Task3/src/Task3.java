
public class Task3 {

	public static void main(String[] args) {
		
	}
	
	static int[] array(int array1[], int number)
	{
		int counter = 0;
		int numberOfNewArray = 0;
		for(int i = 0; i < array1.length; i++)
		{
			if(array1[i] == number)
			{
				numberOfNewArray = array1[i];
				counter++;
			}
			
		}
		int[] allNumbers = new int[counter];
		for(int i = 0; i < counter; i++)
		{
			if(array1[i] == number)
			{
				allNumbers[counter] = array1[i];
				counter++;
			}
			
		}
		
		
		
		
		return allNumbers;	
		
		
	}
	
	
	
	
	
}
