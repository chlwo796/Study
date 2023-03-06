package javaHigh10.example01;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamEx01 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("C:/JHC/data1.txt");

		byte a = 10;
		byte b = 20;
		byte c = 30;

		fos.write(a);
		fos.write(b);
		fos.write(c);

		fos.flush();
		fos.close();

	}
}
