package javaHigh10.example04;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class ReadEx {
	public static void main(String[] args) throws IOException {
		Reader reader = new FileReader("C:/JHC/메모.txt");
		Writer writer = new FileWriter("C:/JHC/메모1.txt");

		while (true) {
			int data = reader.read();
			if (data == -1) {
				break;
			}
			System.out.print((char) data);
			writer.write(data);
		}
		writer.flush();
		writer.close();
		reader.close();

		reader = new FileReader("C:/JHC/메모.txt");
		writer = new FileWriter("C:/JHC/메모2.txt");
		System.out.println();
		char[] data = new char[100];
		while (true) {
			int num = reader.read(data);
			System.out.println(num);
			if (num == -1) {
				System.out.println(num);
				break;
			}
			for (int i = 0; i < num; i++) {
				System.out.print(data[i]);
			}
			writer.write(data);
		}
		writer.flush();
		writer.close();
		reader.close();
	}
}