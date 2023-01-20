package ch05.assignment;

import java.util.Scanner;

public class IdentificationClass {
	
	public static void main(String[] args) {
//		class를 활용한 방법(setter, getter)
//		주민등록번호에서 7번째 자리 (1,3 -> 남자), (2, 4 -> 여자)
//		생년월일을 잘라서 년도 구하기, 월 구하기, 일구하기
		
//		수업시간때 배운 내용을 바탕으로 입출력 메소드 및 계산 클래스의 메소드를 활용해봤다.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("주민등록번호를 입력하세요(\"-\"포함)>");
		String input = sc.nextLine();
		Number nb = new Number();
		nb.setSsn(input);
		System.out.println(nb.getSsn());
		
		Calculator1 cal = new Calculator1();
		cal.genderMethod(nb.getSsn());
		cal.birthDay(nb.getSsn());
		
		System.out.println(cal.ssn);
		System.out.println(cal.gender);
		System.out.println(cal.year + "년생 " + cal.month + "월 " + cal.day + "일");

		
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
			gender = "남자";
		}else if(genderNumber == '2' || genderNumber == '4') {
			gender = "여자";
		}else gender = "외국인";
	}
	
	public void birthDay(String ssn) {
		this.ssn = ssn;
		
		year = ssn.substring(0, 2);
		
		month = ssn.substring(2, 4);
		
		day = ssn.substring(4, 6);
	}

}

