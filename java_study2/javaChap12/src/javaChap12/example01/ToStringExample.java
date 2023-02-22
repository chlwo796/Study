package javaChap12.example01;

public class ToStringExample {
	public static void main(String[] args) {
		SmartPhone smartPhone = new SmartPhone("삼성전자", "안드로이드");
		
		String str = smartPhone.toString();
		
		System.out.println(str);
		System.out.println("객체의 주소만 담은 변수만 넣어줘도 자동으로 toString 메소드 호출");
		System.out.println(smartPhone);
	}
}
