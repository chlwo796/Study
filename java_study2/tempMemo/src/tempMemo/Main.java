package tempMemo;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String str = sc.next();
//		int number = sc.nextInt();
//
//		School school1 = new School("Jejuelementary", 6);
//		School school2 = new School(str, number);
//		System.out.println(school1);
//		System.out.println(school2);

//		sc.close();
		School school = new School("���Ѱ���б�");
		System.out.println(school);

		school = new School("������б�", "���");
		System.out.println(school);
		
		school = new School("�̻����б�", "����", "����ȯ");
		System.out.println(school);
		
		
	}
}