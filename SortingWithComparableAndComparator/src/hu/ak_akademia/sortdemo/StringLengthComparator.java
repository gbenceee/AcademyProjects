package hu.ak_akademia.sortdemo;

import java.util.Comparator;

public class StringLengthComparator implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		int length1 = s1.length();
		int length2 = s2.length();
		if (length1 < 	 length2) {
			return -1;
		} else if (length1 > length2) {
			return 1;
		}
		
		return 0;
	}

}
