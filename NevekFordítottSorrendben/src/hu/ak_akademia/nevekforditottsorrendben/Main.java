package hu.ak_akademia.nevekforditottsorrendben;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Üdvözlöm!");
		System.out.println("A program neveket fog bekérni. A program befejezi a nevek bekéréset amennyiben nem ad meg semmit.");
		Scanner scan = new Scanner(System.in);
		String name;
		List<String> listOfNames = new ArrayList<>();
		do {
			System.out.println("Kérem, adjon meg egy nevet.");
			name = scan.nextLine();
			if (!name.equals("")) {
				listOfNames.add(name);
			}
		} while (!name.equals(""));
		scan.close();
		Collections.reverse(listOfNames);
		System.out.println("A megadott nevek fordított sorrendben: " + listOfNames);
	}

}
