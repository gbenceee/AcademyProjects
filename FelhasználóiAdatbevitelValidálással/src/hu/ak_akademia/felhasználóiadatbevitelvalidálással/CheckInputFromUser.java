package hu.ak_akademia.felhasználóiadatbevitelvalidálással;

import hu.ak_akademia.integerdatatype.IntegerDataTypeValidable;
import hu.ak_akademia.stringdatatype.StringDataTypeValidable;

public class CheckInputFromUser {

	public void checkStringInputFromUser(boolean condition) {
		if (condition) {
			System.out.println("A megadott szöveg megfelelő.");
		} else {
			System.out.println("A megadott szöveg helytelen.");
		}
	}

	public void checkIntegerInputFromUser(boolean condition) {
		if (condition) {
			System.out.println("A megadott szám megfelelő.");
		} else {
			System.out.println("A megadott szám helytelen.");
		}

	}

	public void checkDoubleInputFromUser(boolean condition) {
		if (condition) {
			System.out.println("A megadott szám megfelelő.");
		} else {
			System.out.println("A megadott szám helytelen.");
		}

	}

	public void checkLogicalInputFromUser(boolean condition) {
		if (condition) {
			System.out.println("A megadott logikai érték megfelelő.");
		} else {
			System.out.println("A megadott logikai helytelen.");
		}

	}
}
