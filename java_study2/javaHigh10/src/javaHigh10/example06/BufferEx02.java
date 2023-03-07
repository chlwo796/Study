package javaHigh10.example06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

public class BufferEx02 {
	public static void main(String[] args) throws IOException {
		Reader reader1 = new FileReader("C:/JHC/메모.txt", Charset.forName("UTF-8"));
		Writer writer1 = new FileWriter("C:/JHC/copy메모.txt", Charset.forName("UTF-8"));

		timeCheck(reader1, writer1, "버퍼미사용");

		writer1.close();
		reader1.close();

		Reader reader2 = new FileReader("C:/JHC/메모.txt", Charset.forName("UTF-8"));
		Writer writer2 = new FileWriter("C:/JHC/copy메모2.txt", Charset.forName("UTF-8"));
		BufferedReader br = new BufferedReader(reader2);
		BufferedWriter bw = new BufferedWriter(writer2);

		timeCheck(br, bw, "버퍼사용");

		bw.close();
		br.close();
	}

	public static void timeCheck(Reader reader, Writer writer, String str) throws IOException {
		long startTime = System.nanoTime();
		char[] bytes = new char[1024];
		while (true) {
			int num = reader.read(bytes);
			if (num == -1) {
				break;
			}
			writer.write(bytes, 0, num);
		}
		writer.flush();
		long endTime = System.nanoTime();
		System.out.println(str);
		System.out.println(endTime - startTime);
	}
}