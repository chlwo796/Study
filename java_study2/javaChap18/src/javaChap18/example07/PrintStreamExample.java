package javaChap18.example07;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamExample {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("C:/JHC/printstream.txt");
		PrintStream ps = new PrintStream(fos);
		
		ps.print("��ġ");
		ps.println("�����Ͱ� ����ϴ� ��ó��");
		ps.println("�����͸� ����մϴ�.");
		
		ps.printf("|%6d | %-10s | %10s | \n", 1, "ȫ�浿", "�ڹ�");
		ps.printf("|%6d | %-10s | %10s | \n", 2, "��浿", "�л�");
		
		ps.flush();
		ps.close();
	}
}