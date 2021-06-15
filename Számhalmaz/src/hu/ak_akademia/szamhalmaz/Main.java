package hu.ak_akademia.szamhalmaz;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Üdvözlöm!");
		System.out.println("A program egész számokat fog bekérni. A program befejezi a számok bekéréset amennyiben 0-át ad meg.");
		Scanner scan = new Scanner(System.in);
		int number;
		List<Integer> listOfNumbers = new LinkedList<>();
		do {
			System.out.println("Kérem, adjon meg egy számot!");
			number = scan.nextInt();
			if (!listOfNumbers.contains(number)) {
				System.out.println(number);
			}
			if (number != 0) {
				listOfNumbers.add(number);
			}
		} while (number != 0);
		scan.close();
		System.out.println("A megadott számok a bevitel sorrendjében: " + listOfNumbers);
		Collections.shuffle(listOfNumbers);
		System.out.println("A megadott számok véletlenszerű sorrendben: " + listOfNumbers);
		Collections.sort(listOfNumbers);
		System.out.println("A megadott számok növekvő sorrendben: " + listOfNumbers);
		Collections.sort(listOfNumbers, Collections.reverseOrder());
		System.out.println("A megadott számok csökkenő sorrendben: " + listOfNumbers);
		System.out.println("A program leáll.");
	}

}
