package javaHigh10.example06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferEx01 {
	public static void main(String[] args) throws IOException {
		String filePath1 = BufferEx01.class.getResource("1.jpg").getPath();
		String targetPath1 = "C:/JHC/1.jpg";

		FileInputStream fis1 = new FileInputStream(filePath1);
		FileOutputStream fos1 = new FileOutputStream(targetPath1);

		String filePath2 = BufferEx01.class.getResource("2.jpg").getPath();
		String targetPath2 = "C:/JHC/2.jpg";

		long nonBufferTime = copy(fis1, fos1);

		FileInputStream fis2 = new FileInputStream(filePath2);
		FileOutputStream fos2 = new FileOutputStream(targetPath2);

		System.out.println("버퍼 미사용 : " + nonBufferTime + "나노초");
		BufferedInputStream bis = new BufferedInputStream(fis2);
		BufferedOutputStream bos = new BufferedOutputStream(fos2);
		
		
		long bufferTime = copy(bis, bos);
		
		
		System.out.println("버퍼 사용 : " + bufferTime + "나노초");
		bos.close();
		bis.close();

		fos2.close();
		fis2.close();

		fis1.close();
		fos1.close();
	}

	public static long copy(InputStream is, OutputStream os) throws IOException {
		long startTime = System.nanoTime();

		while (true) {
			int num = is.read();
			if (num == -1) {
				break;
			}
			os.write(num);
		}
		os.flush();
		long endTime = System.nanoTime();
		return endTime - startTime;
	}
}