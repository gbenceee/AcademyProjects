import java.util.Scanner;

public class PalindromEllenőrzése {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Kérlek, adj meg egy szót!");
		String word = scan.nextLine();
		char[] reversedWord = new char[word.length()];
		int counter = 0;
		for (int i = 0, j = word.length() - 1; i < word.length() && j >= 0; i++, j--) {
			reversedWord[i] = word.charAt(j);
			if (word.charAt(i) == word.charAt(j)) {
				counter++;
			}
		}
		if (counter == word.length()) {
			System.out.println("A megadott szó palindrom.");
		} else {
			System.out.print("A szó megfordítva: ");
			for (int k = 0; k < reversedWord.length; k++) {
				System.out.print(reversedWord[k]);
			}
		}
	}
}
