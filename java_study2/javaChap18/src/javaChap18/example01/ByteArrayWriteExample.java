package javaChap18.example01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ByteArrayWriteExample {
	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("C:/JHC/test2.db");

			byte[] array = { 10, 30, 50 };
			os.write(array);
			os.flush();
			os.close();
		} catch (IOException e) {

		}
	}
}
