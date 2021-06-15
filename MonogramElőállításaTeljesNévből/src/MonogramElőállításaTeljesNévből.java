import java.util.Scanner;

public class MonogramElőállításaTeljesNévből {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		String name;
		do {
			name = scanNameFromUser("Kérlek, add meg a neved.");
			if (isFirstCharacterSpace(name)) {
				System.out.println("Nem kezdődhet szóközzel.");
			}
			if (isLastCharacterSpace(name)) {
				System.out.println("Nem lehet az utolsó karakter szóköz.");
			}
		} while (isFirstCharacterSpace(name) | isLastCharacterSpace(name));
		char[] characters = name.toCharArray();
		printMonogram(characters, name);
	}

	static String scanNameFromUser(String message) {
		System.out.println(message);
		String name = scan.nextLine();
		return name;
	}

	static boolean isFirstCharacterSpace(String name) {
		return name.startsWith(" ");
	}

	static boolean isLastCharacterSpace(String name) {
		int index = name.length() - 1;
		return name.startsWith(" ", index);
	}

	static void printMonogram(char[] characters, String name) {
		System.out.print(name.toUpperCase().charAt(0));
		for (int i = 1; i < characters.length; i++) {
			if (characters[i] == ' ' && characters[i + 1] != ' ') {
				char character = Character.toUpperCase(characters[i + 1]);
				System.out.print(character);
			}
		}
	}
}
