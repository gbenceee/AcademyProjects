package hu.ak_akademia.fileinputstreamdemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		FileInputStream in = new FileInputStream("source/13. Fájl IO.pdf");
		FileOutputStream out = new FileOutputStream("source/13. Fájl IO copy.pdf");
		int i;
		while ((i = in.read()) != -1) {
			out.write(i);
		}
		in.close();
		out.close();

	}

}
