package javaChap18.example04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class CharacterConvertStreamExample {
	public static void main(String[] args) throws Exception {
		write("���� ��ȯ ��Ʈ���� ����մϴ�.");
		String data = read();
		System.out.println(data);
	}

	public static void write(String str) throws Exception {
		OutputStream os = new FileOutputStream("C:/JHC/test.txt");
		Writer writer = new OutputStreamWriter(os, "EUC-KR");
		writer.write(str);
		writer.flush();
		writer.close();
	}

	public static String read() throws Exception {
		InputStream is = new FileInputStream("C:/JHC/test.txt");
		Reader reader = new InputStreamReader(is, "EUC-KR");
		char[] data = new char[100];
		int num = reader.read(data);
		reader.close();
		String str = new String(data, 0, num);
		return str;
	}
}