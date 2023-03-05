package javaChap18.example03;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadExample {
	public static void main(String[] args) throws IOException {
		Reader reader = new FileReader("C:/JHC/test1.txt");

		while (true) {
			int data = reader.read();
			if (data == -1) {
				break;
			}
			System.out.print((char) data);

		}
		reader.close();

		reader = new FileReader("C:/JHC/test1.txt");
		char[] data = new char[100];
		while (true) {
			int num = reader.read(data);
			if (num == -1) {
				break;
			}
			for (int i = 0; i < num; i++) {
				System.out.println(data[i]);
			}
		}
		reader.close();
	}
}
