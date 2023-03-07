package javaHigh10.exercise07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Example {
	public static void main(String[] args) throws IOException {
		String filePath = "C:\\JHC\\web_studyB\\study\\java_study2\\javaHigh10\\src\\javaHigh10\\example08\\FilesEx02.java";
		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);

		int rowNumber = 0;
		String rowData = null;
		while (true) {
			rowNumber++;
			rowData = br.readLine();
			System.out.println(rowNumber + ": " + rowData);
			if (rowData == null) {
				break;
			}
		}
		br.close();
		fr.close();
	}

}
