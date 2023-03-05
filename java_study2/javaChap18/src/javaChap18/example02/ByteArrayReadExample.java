package javaChap18.example02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayReadExample {
	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("C:/JHC/test2.db");

		byte[] data = new byte[100];
		while (true) {
			int num = is.read(data);
			if (num == -1) {
				break;
			}
			for (int i = 0; i < num; i++) {
				System.out.println(data[i]);
			}
		}
		is.close();

	}
}
