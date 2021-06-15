package hu.ak_akademia.fizzbuzz;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		GetCorrectInputFromUser get = new GetCorrectInputFromUser(scan);
		int number = get.getInput();
		Print print = new PrintEachNumber(number);
		print.print();
	}

}
