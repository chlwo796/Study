package javaChap18.example03;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteExample {
	public static void main(String[] args) throws IOException {
		Writer writer = new FileWriter("C:/JHC/test1.txt");

		char a = 'a';
		writer.write(a);
		char b = 'b';
		writer.write(b);

		char[] array = { 'c', 'd', 'e' };
		writer.write(array);

		writer.write("ghjy");
		writer.flush();
		writer.close();
	}
}
