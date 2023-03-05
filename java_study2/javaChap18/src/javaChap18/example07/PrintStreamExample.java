package javaChap18.example07;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamExample {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("C:/JHC/printstream.txt");
		PrintStream ps = new PrintStream(fos);
		
		ps.print("마치");
		ps.println("프린터가 출력하는 것처럼");
		ps.println("데이터를 출력합니다.");
		
		ps.printf("|%6d | %-10s | %10s | \n", 1, "홍길동", "자바");
		ps.printf("|%6d | %-10s | %10s | \n", 2, "김길동", "학생");
		
		ps.flush();
		ps.close();
	}
}