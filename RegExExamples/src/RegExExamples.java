
public class RegExExamples {

	public static void main(String[] args) {
		new RegExExamples().run();

	}

	private void run() {
		// A Stringeknek van egy matches nevű metódusa, amiben reguláris kifejezések
		// alapján is lehet egyeztést keresni

		String text = "ABC";
		String text2 = "aazz3";
		String text3 = "aazz45@";

		System.out.println(text + " contains only letters: " + isOnlyLetters(text));
		System.out.println(text2 + " contains only letters: " + isOnlyLetters(text2));
		System.out.println(text3 + " contains only letters: " + isOnlyLetters(text3));

		System.out.println(text + " contains only numbers or letters: " + isOnlyNumbersOrLetters(text));
		System.out.println(text2 + " contains only numbers or letters: " + isOnlyNumbersOrLetters(text2));
		System.out.println(text3 + " contains only numbers or letters: " + isOnlyNumbersOrLetters(text3));

		System.out.println(text + " contains three letters (only capitals): " + isOnlyThreeCapitalLetters(text));
		System.out.println(text2 + " contains three letters (only capitals): " + isOnlyThreeCapitalLetters(text2));
		System.out.println(text3 + " contains three letters (only capitals): " + isOnlyThreeCapitalLetters(text3));

		String number = "a1234";
		String number2 = "1234";
		String number3 = "123456";
		System.out.println(number + " contains from 3 to 5 digits: " + isThreeToFiveDigits(number));
		System.out.println(number2 + " contains from 3 to 5 digits: " + isThreeToFiveDigits(number2));
		System.out.println(number3 + " contains from 3 to 5 digits: " + isThreeToFiveDigits(number3));

		String email = "hello45@akarmi.hu";
		String email2 = "54sanyika@bugyburugy.com";
		String email3 = "tepertős kalács";
		System.out.println(email + " is a valid hungarian email format: " + isValidHungarianEmailFormat(email));
		System.out.println(email2 + " is a valid hungarian email format: " + isValidHungarianEmailFormat(email2));
		System.out.println(email3 + " is a valid hungarian email format: " + isValidHungarianEmailFormat(email3));

		String hour = "XIV";
		String hour2 = "XXIX";
		String hour3 = "XVIV";
		System.out.println(hour + " is a valid hour format: " + isValidHourFormat(hour));
		System.out.println(hour2 + " is a valid hour format: " + isValidHourFormat(hour2));
		System.out.println(hour3 + " is a valid hour format: " + isValidHourFormat(hour3));
	}

	private boolean isOnlyLetters(String text) {
		// csak a és z betűk, illetve A és Z betűk között keresünk (kis- és nagybetűk)
		return text.matches("[a-zA-Z]+");
	}

	private boolean isOnlyNumbersOrLetters(String text) {
		// itt már a 0-9 és közötti karakterek azaz számok is benne lehetnek
		return text.matches("[a-zA-Z0-9]+");
	}

	private boolean isOnlyThreeCapitalLetters(String text) {
		// itt most csak nagybetűket keresünk, három darab engedélyezett
		return text.matches("[A-Z]{3}+");
	}

	private boolean isThreeToFiveDigits(String text) {
		// itt csak számokat engedélyezünk 3 és 5 közötti darabszámra
		return text.matches("[0-9]{3,5}");
	}

	private boolean isValidHungarianEmailFormat(String text) {
		// kisbetűvel, vagy nagybetűvel kezdődjön
		// ezután lehet benne kisbetű, nagybetű, vagy szám,
		// majd legyen kukac ( = @),
		// ezután kis vagy nagybetű
		// majd pont (itt kell a két darab fordított per jel ( \\) különben lehal)
		// végül csak a "hu" kifejezés elfogadható
		return text.matches("[a-zA-Z]+[a-zA-Z0-9]+@[a-zA-Z]+\\.+hu");
	}

	private boolean isValidHourFormat(String text) {
		// 1-24 óráig fogjuk most elfogadni, tehát I-XXIV között
		// az elején lehet nulla vagy egy darab X
		// azután X, vagy IX, vagy IV
		// vagy V és I közül valamelyik, méghozzá I-ből 0 és 3 között
		return text.matches("^X{0,1}(X|IX|IV|V?I{0,3})$");
	}

}
