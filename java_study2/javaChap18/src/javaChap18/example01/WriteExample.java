package javaChap18.example01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("C:/JHC/test1.db");
			byte a = 10;
			byte b = 20;
			byte c = 30;
			os.write(a);
			os.write(b);
			os.write(c);
			os.flush();
			os.close();
		} catch (IOException e) {
		}
		// 디렉토리에 파일생성 확인
	}
}
