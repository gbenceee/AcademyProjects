package hu.ak_akademia.exceptiondemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Helló!");
		try {
			Scanner scanner = new Scanner(new File("res/text.txt"));

			String line1 = scanner.nextLine();
			System.out.println(line1);
			if (line1.contains(" ")) {
				throw new ContainsSpaceRuntimeException("Szóköz van a sorban!");
			}
			if (line1.contains("!")) {
				throw new IllegalCharacterException("Felkiáltójelet tartalmaz a sor.");
			}

			String line2 = scanner.nextLine();
			System.out.println(line2);

			String line3 = scanner.nextLine();
			System.out.println(line3);

			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("A fájl sajnos nem található a megadott helyen. A hiba megnevezése: " + e.getMessage());
			throw new IllegalArgumentException("A megadott fájl nem található.", e);
		} catch (IOException e) {
			System.out.println("IO hiba");
		} catch (NoSuchElementException e) {
			System.out.println("A következő sor nem található.");
		} catch (IllegalCharacterException e) {
			System.out.println("Saját kivétel keletkezett és elkaptuk. Ez az üzenete: " + e.getMessage());
			// } catch (Exception e) {
			// System.out.println("Egyéb hiba volt.");
		}
		System.out.println("Viszlát!");
	}

}
