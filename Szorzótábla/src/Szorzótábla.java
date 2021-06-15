public class Szorzótábla {

	public static void main(String[] args) {
		int[][] multiplicationTable = new int[10][10];
		for(int column = 0; column <= 9; column ++)
		{
			if(column <= 10)
			{
				for(int row = 0; row <= 9; row++)
				{
					multiplicationTable[column][row] = (column + 1) * (row + 1);
					
				}
			}
		}
		for(int i = 0; i <= 9; i++)
		{
			if(i < 1)
			{
				
				System.out.print("  |" + "\t" + (i + 1) + "\t" + " |");
			}
			else
			{
				System.out.print("\t" + multiplicationTable[0][i] + "\t" + " |");
			}
		}
		System.out.println("");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for(int i = 0; i <= 9; i++)
		{
			if(i < 9)
			{
				System.out.print(i + 1 + " |");
			}
			else
			{
				System.out.print(i + 1 + "|");
			}
			if(i <= 9)
			{
				for(int j = 0; j <= 9; j++)
				{
						System.out.print("\t" + multiplicationTable[i][j] + "\t" + " |");
				}
			}
			System.out.println("");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
		
		
		
		
	}

}
