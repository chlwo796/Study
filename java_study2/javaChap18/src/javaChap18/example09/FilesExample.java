package javaChap18.example09;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesExample {
	public static void main(String[] args) throws IOException {
		String data = "" + "id: winter\n" + "email: winter@mycompany.com\n" + "tel: 010-123-1234";
		
		Path path = Paths.get("C:/JHC/user.txt");
		
		Files.writeString(path, data, Charset.forName("UTF-8"));
		
		System.out.println("���� ���� : " + Files.probeContentType(path));
		System.out.println("���� ũ�� : " + Files.size(path) + "bytes");
		
		String content = Files.readString(path, Charset.forName("UTF-8"));
		System.out.println(content);
	}
}