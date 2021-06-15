package hu.ak_akademia.dataoutputstreamdemo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
//		try (DataOutputStream out = new DataOutputStream(new FileOutputStream("binaryFile.bin"))) {
//			out.writeByte(0);
//			out.writeByte(0);
//			out.writeByte(0);
//			out.writeByte(0);
//			for (int i = 0; i < 1_000; i++) {
//				out.writeInt(i);
//			}
//		}
//		try (DataInputStream in = new DataInputStream(new FileInputStream("binaryFile.bin"))) {
//			for (int i = 0; i < 1_000; i++) {
//				System.out.println(in.read());
//			}
//		}
//		System.out.println("Program vége");
//		try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt"), "ISO-8859-2"))) {
//			String line = in.readLine();
//			System.out.println(line);
//		}
//		System.out.println("Program vége");
//		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("objects.bin"))){
//			for (int i = 0; i < 1; i++) {
//				out.writeObject(new Auto(8,5));
//			}
//		}
//		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("objects.bin"))) {
//			for (int i = 0; i < 1; i++) {
//				Auto auto = (Auto) in.readObject();
//				System.out.println(auto);
//			}
//		}
//		System.out.println("Program vége");
		Person bence = new Person(24, new DateOfBirth(1996, 1, 15));
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("people.bin"))){
			for (int i = 0; i < 1; i++) {
				out.writeObject(bence);
			}
		}
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("people.bin"))) {
			for (int i = 0; i < 1; i++) {
				Person másikBence = (Person) in.readObject();
				System.out.println(másikBence);
			}
		}
		System.out.println("Program vége");
	}

}
