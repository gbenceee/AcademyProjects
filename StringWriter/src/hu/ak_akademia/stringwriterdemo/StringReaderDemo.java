package hu.ak_akademia.stringwriterdemo;

import java.io.IOException;
import java.io.StringReader;

public class StringReaderDemo {

	public static void main(String[] args) {
		String data = "First line\nSecond line\nThird line";
		try (StringReader stringReader = new StringReader(data)) {
			data = "hello";
			for (int character = stringReader.read(); character != -1; character = stringReader.read()) {
				System.out.print((char) character);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
