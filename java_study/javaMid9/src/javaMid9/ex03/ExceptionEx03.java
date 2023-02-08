package javaMid9.ex03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionEx03 {
	public static void main(String[] args) {
//		try {
//			FileInputStream file1 = new FileInputStream("c:/qqq/web_studyB/study/a.txt");
//		} catch (FileNotFoundException e) {
//			컴파일러가 자동으로 try-catch문을 만들도록 함
//			e.printStackTrace();
//		}
		try {
			Class.forName("java.util.String");
			int a = 10/0;	
			int[] number = {12,30,40,50,10};
			System.out.println(number[6]);
		} catch (ClassNotFoundException e) {
//			예외발생하는 타입을 맞춰야 한다.
			e.printStackTrace(); // 예외가 어떻게 발생했는지 과정을 추적한다.
		} catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println("수학적으로 예외발생");
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("배열 예외");
		}
		finally {
			System.out.println("정상종료");
		}
	}
}
