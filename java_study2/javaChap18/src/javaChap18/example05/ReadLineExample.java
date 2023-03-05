package javaChap18.example05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLineExample {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/javaChap18/example05/ReadLineExample.java"));
		int lineNo = 1;
		while (true) {
			String str = br.readLine();
			if (str == null) {
				break;
			}
			System.out.println(lineNo + "\t" + str);
			lineNo++;
		}
		br.close();
	}
}