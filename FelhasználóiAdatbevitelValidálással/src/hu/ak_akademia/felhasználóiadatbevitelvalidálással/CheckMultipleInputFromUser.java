package hu.ak_akademia.felhasználóiadatbevitelvalidálással;

import hu.ak_akademia.doubledatatype.DoubleDataTypeValidable;
import hu.ak_akademia.integerdatatype.IntegerDataTypeValidable;
import hu.ak_akademia.logicalvaluedatatype.LogicalValueValidable;
import hu.ak_akademia.stringdatatype.StringDataTypeValidable;

public class CheckMultipleInputFromUser {

	public void checkMultipleIntegerInputFromUser(int[] integerNumbersFromUser, IntegerDataTypeValidable... condition) {
		boolean isCorrect = true;
		loop: for (int i = 0; i < integerNumbersFromUser.length; i++) {
			for (int j = 0; j < condition.length; j++) {
				if (!condition[j].isValid(integerNumbersFromUser[i])) {
					System.out.println("A megadott szám (" + integerNumbersFromUser[i] + ") helytelen.");
					isCorrect = false;
					break loop;
				}
			}
		}
		if (isCorrect) {
			System.out.println("A megadott szám(ok) megfelelő(ek).");
		}
	}

	public void checkMultipleDoubleInputFromUser(double[] doubleNumbersFromUser, DoubleDataTypeValidable... condition) {
		boolean isCorrect = true;
		loop: for (int i = 0; i < doubleNumbersFromUser.length; i++) {
			for (int j = 0; j < condition.length; j++) {
				if (!condition[j].isValid(doubleNumbersFromUser[i])) {
					System.out.println("A megadott szám (" + doubleNumbersFromUser[i] + ") helytelen.");
					isCorrect = false;
					break loop;
				}
			}
		}
		if (isCorrect) {
			System.out.println("A megadott szám(ok) megfelelő(ek).");
		}
	}

	public void checkMultipleStringInputFromUser(String[] stringsFromUser, StringDataTypeValidable... condition) {
		boolean isCorrect = true;
		loop: for (int i = 0; i < stringsFromUser.length; i++) {
			for (int j = 0; j < condition.length; j++) {
				if (!condition[j].isValid(stringsFromUser[i])) {
					System.out.println("A megadott szöveg (" + stringsFromUser[i] + ") helytelen.");
					isCorrect = false;
					break loop;
				}
			}
		}
		if (isCorrect) {
			System.out.println("A megadott szöveg(ek) megfelelő(ek).");
		}
	}

	public void checkMultipleLogicalValueFromUser(String[] logicalValuesFromUser, LogicalValueValidable... condition) {
		boolean isCorrect = true;
		loop: for (int i = 0; i < logicalValuesFromUser.length; i++) {
			for (int j = 0; j < condition.length; j++) {
				if (!condition[j].isValid(logicalValuesFromUser[i])) {
					System.out.println("A megadott logikai érték (" + logicalValuesFromUser[i] + ") helytelen.");
					isCorrect = false;
					break loop;
				}
			}
		}
		if (isCorrect) {
			System.out.println("A megadott logikai érték(ek) megfelelő(ek).");
		}
	}
}
