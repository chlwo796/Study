package javaHigh10.exercise10;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Example {
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		System.out.println("���� ���� ��� : ");
		String input = sc.nextLine();
		System.out.println("���� ���� ��� : ");
		String output = sc.nextLine();
		File file = new File(input);

		if (!file.exists()) {
			System.out.println("���� ������ �������� �ʽ��ϴ�.");
			System.exit(0);
		}
		File copyFile = new File(output);
		if (!copyFile.getParentFile().exists()) {
			copyFile.getParentFile().mkdir();
			copyFile.createNewFile();
			System.out.println("���簡 �����Ǿ����ϴ�.");
		}

		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);

		FileOutputStream fos = new FileOutputStream(copyFile);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		byte[] bytes = new byte[1024];
		while (true) {
			int num = bis.read(bytes);
			if (num == -1) {
				System.out.println("���簡 �����Ǿ����ϴ�.");
				break;
			}
			bos.write(num);
		}
		bos.flush();
		fos.flush();
		bis.close();
		fos.close();
	}
}