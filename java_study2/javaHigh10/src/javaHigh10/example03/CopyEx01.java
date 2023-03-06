package javaHigh10.example03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class CopyEx01 {
	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("C:/JHC/web_studyB/study/web_study/image/1.jpg");
		OutputStream os = new FileOutputStream("C:/JHC/web_studyB/project_file/1.jpg");

		// 기억용량 단위, 정보표현단위 = bit, 문자표현단위 1byte = 1글자 1kb = 1024byte

		byte[] b = new byte[1024];
		while (true) {
			int num = is.read(b);
			if (num == -1) {
				break;
			}
			os.write(b, 0, num);
		}
		os.flush();
		os.close();
		is.close();

		is = new FileInputStream("C:/JHC/data4.txt");
		os = new FileOutputStream("C:/JHC/copydata4.txt");
		while (true) {
			int num = is.read(b);
			if (num == -1) {
				break;
			}
			os.write(b, 0, num);
		}
		os.flush();
		os.close();
		is.close();

		is = new FileInputStream("C:\\Program Files\\Java\\jdk1.8.0_202/javafx-src.zip");
		os = new FileOutputStream("C:/JHC/copyjavafx-src.zip");
		while (true) {
			int num = is.read(b);
			if (num == -1) {
				break;
			}
			os.write(b, 0, num);
		}
		os.flush();
		os.close();
		is.close();
	}
}