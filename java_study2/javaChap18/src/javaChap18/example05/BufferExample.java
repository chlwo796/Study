package javaChap18.example05;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferExample {
	public static void main(String[] args) throws IOException {
		String originalFilePath1 = BufferExample.class.getResource("test1.png").getPath();

		String targetFilePath1 = "C:/JHC/targetFile1.png";

		FileInputStream fis1 = new FileInputStream(originalFilePath1);
		FileOutputStream fos1 = new FileOutputStream(targetFilePath1);

		String originalFilePath2 = BufferExample.class.getResource("test2.png").getPath();

		String targetFilePath2 = "C:/JHC/targetFile2.png";

		FileInputStream fis2 = new FileInputStream(originalFilePath2);
		FileOutputStream fos2 = new FileOutputStream(targetFilePath2);

		BufferedInputStream bis = new BufferedInputStream(fis2);
		BufferedOutputStream bos = new BufferedOutputStream(fos2);
		long nonBufferTime = copy(fis1, fos1);
		System.out.println("버퍼 미사용 : " + nonBufferTime + "ns");
		long bufferTime = copy(bis, bos);
		System.out.println("버퍼 사용 : " + bufferTime + "ns");

	}

	public static long copy(InputStream is, OutputStream os) throws IOException {
		long startTime = System.nanoTime();
		while (true) {
			int data = is.read();
			if (data == -1) {
				break;
			}
			os.write(data);
		}
		is.close();
		os.flush();
		os.close();
		long endTime = System.nanoTime();

		return endTime - startTime;
	}
}
