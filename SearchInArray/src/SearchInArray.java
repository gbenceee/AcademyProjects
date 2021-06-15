import java.util.Arrays;

public class SearchInArray {

	public static void main(String[] args) {
		//Hárommal osztható számok kiírása 
		int[] array = { 3, 73, 43, 12, 107, 5, 6 };
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 3 == 0) {
				System.out.println(array[i]);

			}

		}
		System.out.println("");
		System.out.println("");
		//Hárommal osztható számok kiírása egymás mellé vesszővel és szóközzel elválasztva
		int[] array1 = { 3, 73, 43, 12, 107, 5, 6 };
		for (int i = 0; i < array1.length; i++) 
		{
			if (array1[i] % 3 == 0) 
			{
				if (array1[i] != 6) 
				{
					System.out.print(array1[i] + ", ");
				} 
				else 
				{
					System.out.print(array1[i]);
				}

			}

		}
		//Megoldás
		System.out.println("");
		System.out.println("---------------------------");
		System.out.println("Megoldás:");
		System.out.println("");
		boolean first = true;
		for (int number : array1) 
		{
			if(number % 3 == 0)
			{
				if(first)
				{
					System.out.print(number);
				}
				else
				{
					System.out.print(", " + number);
				}
				first = false;
			}
		}
		
		//Megoldás v2
		
		System.out.println("");
		System.out.println("---------------------------");
		System.out.println("Megoldás v2:");
		System.out.println("");
		boolean firstt = true;
		for (int number : array1) 
		{
			if(number % 3 == 0)
			{
				System.out.print((firstt ? "" : ", ") + number);
				firstt = false;
			}
		}
		
		//Megoldás v3
		System.out.println("");
		System.out.println("---------------------------");
		System.out.println("Megoldás v3:");
		System.out.println("");
		String separator = "";
		for (int number : array1) 
		{
			if(number % 3 == 0)
			{
				System.out.print(separator + number);
				separator = ", ";
			}
		}
		System.out.println("");
		System.out.println("---------------------------");
		System.out.println("");
		//Hárommal osztható számok másolása egyik tömbből a másikba
		int[] array2 = { 3, 73, 43, 12, 107, 5, 6 };
		int[] results = new int[array2.length];
		int index = 0;
		for(int i = 0; i < array2.length; i++)
		{
			if( array2[i] % 3 == 0)
			{
				results[index] = array2[i];
				index++;
			}
			
		}
		for (int i = 0; i < index; i++)
		{
			System.out.println(results[i]);
		}
		System.out.println("");
		System.out.println("---------------------------");
		System.out.println("");
		int[] finalResult = new int[index];
		System.arraycopy(results, 0, finalResult, 0, index);
		for (int result : finalResult) 
		{
			System.out.println(result);
		}
		System.out.println("A végeredmény tömb mérete: " + finalResult.length); /*vagy index a finalResult.length helyett*/
		System.out.println("");
		System.out.println("---------------------------");
		System.out.println("");
		
		// 0. bemeneti számok tömbjének létrehozása
		int[] array4 = { 3, 73, 43, 12, 107, 5, 6 };
		// 1. 3-mal osztható számok megszámolása a bemeneti tömbben
		int counter = 0;
		for (int number : array4) 
		{
			if(number % 3 == 0)
			{
				counter++;
			}
		}

		// 2. megfelelő méretű eredmény tömb létrehozása
		
		int[] result4 = new int [counter];
		int index2 = 0;
		for (int number : array4) 
		{
			if(number % 3 == 0)
			{
				result4[index2] = number;
				index2++;
			}
		}
		//4. eredmény tömbök kiírása
		System.out.println(Arrays.toString(result4));
		System.out.println("");
		int[] array5 = { 3, 73, 43, 12, 107, 5, 6 };
		int index3 = 0;
		for(int i = array5.length - 1; i >= 0; i--)
		{
			System.out.println(array5[i]);
		}
		
		System.out.println("");
		
		int[] original = { 3, 73, 43, 12, 107, 5, 6 };
		int[] reversed = new int [original.length];
		
		for(int i = 0; i < original.length; i++)
		{
			reversed[original.length - i - 1 ] = original[i];
		}
		
		System.out.println("Eredeti   : " + Arrays.toString(original));
		System.out.println("Fordított : " + Arrays.toString(reversed));
		
		

	}

}

