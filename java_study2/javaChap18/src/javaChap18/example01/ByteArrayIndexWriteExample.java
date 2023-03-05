package javaChap18.example01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ByteArrayIndexWriteExample {
	public static void main(String[] args) throws IOException {
		OutputStream os = new FileOutputStream("C:/JHC/test3.db");
		byte[] array = { 10, 40, 20, 50, 60 };

		os.write(array, 1, 2);
		os.flush();
		os.close();

	}
}