package javaHigh10.example05;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class CharStreamReaderEx {
	public static void main(String[] args) throws Exception {
		write("문자 변환 스트림을 사용합니다.");
		String data = read();
		System.out.println(data);
	}

	public static void write(String str) throws Exception {
//		OutputStream os = new FileOutputStream("C:/JHC/test.txt");
//		Writer writer = new OutputStreamWriter(os, "EUC-KR");
		// 변수에 담지 않고 생성
		Writer writer = new OutputStreamWriter(new FileOutputStream("C:/JHC/test.txt"), "EUC-KR");
		writer.write(str);
		writer.flush();
		writer.close();
	}

	public static String read() throws Exception {
//		InputStream is = new FileInputStream("C:/JHC/test.txt");
//		Reader reader = new InputStreamReader(is, "EUC-KR");
		Reader reader = new InputStreamReader(new FileInputStream("C:/JHC/test.txt"), "EUC-KR");
		char[] data = new char[100];
		StringBuilder sb = new StringBuilder();
		while (true) {
			int num = reader.read(data);
			if (num == -1) {
				break;
			}
			for (int i = 0; i < num; i++) {
				sb.append(data[i]);
			}
		}
		reader.close();
		return sb.toString();
	}
}