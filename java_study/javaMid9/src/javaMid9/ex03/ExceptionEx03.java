package javaMid9.ex03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionEx03 {
	public static void main(String[] args) {
//		try {
//			FileInputStream file1 = new FileInputStream("c:/qqq/web_studyB/study/a.txt");
//		} catch (FileNotFoundException e) {
//			�����Ϸ��� �ڵ����� try-catch���� ���鵵�� ��
//			e.printStackTrace();
//		}
		try {
			Class.forName("java.util.String");
			int a = 10/0;	
			int[] number = {12,30,40,50,10};
			System.out.println(number[6]);
		} catch (ClassNotFoundException e) {
//			���ܹ߻��ϴ� Ÿ���� ����� �Ѵ�.
			e.printStackTrace(); // ���ܰ� ��� �߻��ߴ��� ������ �����Ѵ�.
		} catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println("���������� ���ܹ߻�");
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("�迭 ����");
		}
		finally {
			System.out.println("��������");
		}
	}
}
