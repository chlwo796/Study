package javaHigh10.example02;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamEx01 {
	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("C:/JHC/data5.txt");
		DataInputStream dis = new DataInputStream(is);
		double[] doubleArray = new double[5];
		int count = 0;
		while (true) {

			doubleArray[count] = dis.readDouble();

			if (count == 4) {
				break;
			}
			count++;
			// EOF = End of File

		}
		for (int i = 0; i < doubleArray.length; i++) {
			System.out.println(doubleArray[i]);
		}
		dis.close();
		is.close();
	}
}