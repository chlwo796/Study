package ch04.sec05;

import java.util.Scanner;

public class KeyControlExample {

	public static void main(String[] args) {
//		1,2�� �Է����� �� �ӵ��� ����,���ӽ�Ű�� 3�� �Է��ϸ� ���������ϴ� ���α׷�
		Scanner sc = new Scanner(System.in);
		int speed = 0;
		
		while(true) {
			System.out.println("-----------------------");
			System.out.println("1. ���� | 2. ���� | 3. ����");
			System.out.println("-----------------------");
			System.out.println("����>");
			int key = sc.nextInt();

			if(key == 1) {
				speed = speed + 1;
				System.out.println("���� �ӵ� =" + speed);
			}else if(key == 2) {
				speed = speed -1;
				System.out.println("���� �ӵ� =" + speed);
			}else break;
		}
		System.out.println("����");
//		break;�� ������� �ʰ�� boolean ������ ���� �����Ͽ� true<->false�� while���� ��Ʈ�� �� �� �ִ�.
	}

}
