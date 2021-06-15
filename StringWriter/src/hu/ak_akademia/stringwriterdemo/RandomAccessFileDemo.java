package hu.ak_akademia.stringwriterdemo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
	public static void main(String[] args) throws IOException {
		try (RandomAccessFile randomAccessFile = new RandomAccessFile(new File("input.txt"), "rw")) {
			randomAccessFile.seek(13);
			randomAccessFile.write("2".getBytes());
			randomAccessFile.seek(21);
			randomAccessFile.write("3".getBytes());
		}
	}
}
