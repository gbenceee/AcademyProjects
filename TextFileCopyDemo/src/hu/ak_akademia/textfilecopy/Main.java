package hu.ak_akademia.textfilecopy;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		FileReader in = new FileReader("source/copy-from.txt");
		FileWriter out = new FileWriter("source/copy-to.txt");
		int i; 
		while((i = in.read())!= -1) {
			out.write(i);
		}
		out.close();
		in.close();
	}

}
