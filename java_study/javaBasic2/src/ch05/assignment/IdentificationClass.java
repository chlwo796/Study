package ch05.assignment;

import java.util.Scanner;

public class IdentificationClass {
	
	public static void main(String[] args) {
//		class�� Ȱ���� ���(setter, getter)
//		�ֹε�Ϲ�ȣ���� 7��° �ڸ� (1,3 -> ����), (2, 4 -> ����)
//		��������� �߶� �⵵ ���ϱ�, �� ���ϱ�, �ϱ��ϱ�
		
//		�����ð��� ��� ������ �������� ����� �޼ҵ� �� ��� Ŭ������ �޼ҵ带 Ȱ���غô�.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("�ֹε�Ϲ�ȣ�� �Է��ϼ���(\"-\"����)>");
		String input = sc.nextLine();
		Number nb = new Number();
		nb.setSsn(input);
		System.out.println(nb.getSsn());
		
		Calculator1 cal = new Calculator1();
		cal.genderMethod(nb.getSsn());
		cal.birthDay(nb.getSsn());
		
		System.out.println(cal.ssn);
		System.out.println(cal.gender);
		System.out.println(cal.year + "��� " + cal.month + "�� " + cal.day + "��");

		
	}
}

class Number {
	
	String ssn;

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
}

class Calculator1{
	String ssn;
	String year;
	String month;
	String day;
	String gender;
	
	public void genderMethod(String ssn) {

		this.ssn = ssn;
		char genderNumber = ssn.charAt(7);
		
		if(genderNumber == '1' || genderNumber == '3') {
			gender = "����";
		}else if(genderNumber == '2' || genderNumber == '4') {
			gender = "����";
		}else gender = "�ܱ���";
	}
	
	public void birthDay(String ssn) {
		this.ssn = ssn;
		
		year = ssn.substring(0, 2);
		
		month = ssn.substring(2, 4);
		
		day = ssn.substring(4, 6);
	}

}

