package student.Management;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//���� ȭ�� �� �α��� �޼ҵ�
		
		Scanner sc = new Scanner(System.in);
		Login login = new Login();
		AttendanceManage atdm = new AttendanceManage(null);
		
		System.out.println("-----------------");
		System.out.println("�����п� ���� ���α׷�");
		System.out.println("-----------------");
		System.out.println("�ڵ带 �Է��ϼ���\n������ > 0 \n�л� > 1");
		int inputCode = sc.nextInt();
		switch(inputCode) {
		case 0 : {
			System.out.println("�����ڰ� �α����� �մϴ�"); 
			login.login();
		}break;
		case 1 : {
			System.out.println("�л��� �α����� �մϴ�"); 
			atdm.studentArrive();
		}break;
		default: {
			System.out.println("�߸��� �Է��Դϴ�.");
			System.out.println("���α׷��� �����մϴ�.");
			}break;
		}
		
	}
}