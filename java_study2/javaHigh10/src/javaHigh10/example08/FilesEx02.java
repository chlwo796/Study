package javaHigh10.example08;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesEx02 {
	public static void main(String[] args) throws IOException {
		String data = "id: winter\n" + "email:winter@mycompany.com\n" + "tel: 010-123-1234";

		Path path = Paths.get("C:/JHC/user.txt");

		Files.writeString(path, data, Charset.forName("UTF-8"));

		System.out.println("파일 유형 : " + Files.probeContentType(path));
		System.out.println("파일 크기 : " + Files.size(path) + "bytes");

		String str = Files.readString(path, Charset.forName("UTF-8"));
		System.out.println(str);
	}
}