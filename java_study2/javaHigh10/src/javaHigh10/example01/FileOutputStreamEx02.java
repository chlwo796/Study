package javaHigh10.example01;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.Arrays;

public class FileOutputStreamEx02 {
	public static void main(String[] args) throws IOException {
		OutputStream os1 = new FileOutputStream("C:/JHC/data2.txt");

		byte[] data1 = { 10, 20, 30, 40, 50 };

		os1.write(data1);
		os1.flush();
		os1.close();

		Writer writer1 = new FileWriter("C:/JHC/data4.txt");

		char[] data2 = { 'a', 'b', 'c', 'd', 'e' };
		writer1.write(data2);

		writer1.flush();
		writer1.close();

		FileOutputStream os2 = new FileOutputStream("C:/JHC/data5.txt");
		DataOutputStream dos = new DataOutputStream(os2);

		double[] data3 = { 1.1, 2.2, 3.3, 4.4, 5.5 };
		Arrays.stream(data3, 0, data3.length).forEach(n -> {
			try {
				dos.writeDouble(n);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		dos.flush();
		dos.close();
		os2.close();
	}
}