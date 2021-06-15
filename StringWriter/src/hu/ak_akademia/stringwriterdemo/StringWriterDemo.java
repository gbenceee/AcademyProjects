package hu.ak_akademia.stringwriterdemo;

import java.io.IOException;
import java.io.StringWriter;

public class StringWriterDemo {

	public static void main(String[] args) throws IOException {
		try (StringWriter writer = new StringWriter()) {
			for (int i = 0; i < 100; i++) {
				writer.append("hello" + i);
			}
			System.out.println(writer.toString());
			System.out.println("Vége");
		}
	}

}
