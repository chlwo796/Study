package ch04.sec06;

import java.util.Scanner;

public class DoWhileExample {

	public static void main(String[] args) {
//		do-while�� �̿��� Ű���� ����� ���α׷�
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�޽����� �Է��ϼ���.\n���α׷��� �����Ͻ÷��� q�� �Է��ϼ���.");
		String inputStr = null;
		
		do {
			System.out.print(">");
			inputStr = sc.nextLine();
			System.out.println(inputStr);
		}while(!inputStr.equals("q"));
		System.out.println("���α׷�����");
		
//		inputStr == "q"��� ���ǽ��� �������� �ʴ´�. ���ڿ��� ���� ��� .equals()��� API�� �̿��Ѵ�.
//		while(���ǽ�)���� ���ǽ��� true�� ���, do{}�� �ݺ����� �ٽ� �����Ѵ�.
		
	}

}
