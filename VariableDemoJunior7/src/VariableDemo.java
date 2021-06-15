
public class VariableDemo {

	public static void main(String[] args) {
		int number;
		number = 10;
		System.out.println(number);
		number = 15;
		System.out.println(number);
		number = 25;
		System.out.println(number);
		System.out.println("------------");
		
		double pi = 3.14;
		System.out.println(pi);
		pi = 0.12345678;
		System.out.println(pi);
		System.out.println("------------");
		
		int[] numbers = new int[5];
		System.out.println(numbers[0]);
		System.out.println(numbers[1]);
		System.out.println(numbers[2]);
		System.out.println(numbers[3]);
		System.out.println(numbers[4]);
		numbers[2] = 42;
		System.out.println("------------");
		System.out.println(numbers[0]);
		System.out.println(numbers[1]);
		System.out.println(numbers[2]);
		System.out.println(numbers[3]);
		System.out.println(numbers[4]);
		System.out.println("------------");
		
		int[] myNumbers = {1, 2, 3, 4,};
		System.arraycopy(numbers, 0, myNumbers, 0, 3);
		System.out.println(myNumbers[0]);
		System.out.println(myNumbers[1]);
		System.out.println(myNumbers[2]);
		System.out.println(myNumbers[3]);
		System.out.println("------------");
		
		
		int[][] sudoku = new int [3][3];
		sudoku[0][0]= 7;
		sudoku[0][1]= 9;
		sudoku[0][2]= 3;
		sudoku[1][0]= 1;
		sudoku[1][1]= 2;
		sudoku[1][2]= 6;
		sudoku[2][0]= 5;
		sudoku[2][1]= 4;
		sudoku[2][2]= 8;
		System.out.print(sudoku[0][0]);
		System.out.print(sudoku[0][1]);
		System.out.println(sudoku[0][2]);
		System.out.print(sudoku[1][0]);
		System.out.print(sudoku[1][1]);
		System.out.println(sudoku[1][2]);
		System.out.print(sudoku[2][0]);
		System.out.print(sudoku[2][1]);
		System.out.println(sudoku[2][2]);
		System.out.println("--------------");
		
		
		
		
		
		
		
		

	}

}
