package javaChap18.example09;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {
	public static void main(String[] args) throws IOException {
		File dir = new File("C:/JHC/images");
		File file1 = new File("C:/JHC/file1.txt");
		File file2 = new File("C:/JHC/file1.txt");
		File file3 = new File("C:/JHC/file1.txt");

		if (dir.exists() == false) {
			dir.mkdir();
		}
		if (file1.exists() == false) {
			file1.createNewFile();
		}
		if (file2.exists() == false) {
			file2.createNewFile();
		}
		if (file3.exists() == false) {
			file3.createNewFile();
		}
		File jhc = new File("C:/JHC");
		File[] content = jhc.listFiles();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		for (File file : content) {
			System.out.printf("%-25s", sdf.format(new Date(file.lastModified())));
			if (file.isDirectory()) {
				System.out.printf("%-10s%-20s\n", "<DIR>", file.getName());
			} else {
				System.out.printf("%-10s%-20s\n", file.length(), file.getName());
			}
		}
		System.out.println();
	}
}
