package ch03.assignment;

import java.util.Scanner;

public class ClassNameOperator {

	public static void main(String[] args) {
		//���� ������ ������ "�ڹ�"��� �Է��ϰ� �ڹٰ� �ƴϸ� "B����,C�����Դϴ�." �ڹٸ� "A�����Դϴ�."��� ����ϱ�
		
		Scanner sc = new Scanner(System.in);
		System.out.print("� �����Դϱ�?");
		String className = sc.nextLine();
		String result2;
		result2 = (className.equals("�ڹ�")) ? "A�����Դϴ�" : "B����, C�����Դϴ�";
		System.out.println(result2);
		
//		if(className.equals("�ڹ�")) {
//			System.out.println("A�����Դϴ�");
//		}else
//			System.out.println("B, C�����Դϴ�");

		
	}

}
