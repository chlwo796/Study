package javaHigh10.example08;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class FilesEx01 {
	public static void main(String[] args) throws IOException {
		File dir = new File("C:/JHC");
		File file1 = new File("C:/JHC/data1.txt");
		File file2 = new File("C:/JHC/data2.txt");
		File file3 = new File("C:/JHC/data3.txt");

		if (dir.exists() == false) {
			dir.mkdir();
		}
		if (file1.exists() == false) {
			file1.createNewFile();
		}
		if (dir.exists() == false) {
			file2.createNewFile();
		}
		if (dir.exists() == false) {
			file3.createNewFile();
		}
		File files = new File("C:/JHC/web_studyB");
		File[] fileList = files.listFiles();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");

		for (File file : fileList) {
			System.out.printf("%-25s", sdf.format(new Date(file.lastModified())));
			if (file.isDirectory()) {
				System.out.printf("%-10s%-20s\n", "<DIR>", file.getName());
			} else {
				System.out.printf("%-10s%-20s\n", file.length(), file.getName());
			}
		}
	}
}
