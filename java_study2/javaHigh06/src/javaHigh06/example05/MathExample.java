package javaHigh06.example05;

import java.util.Random;

public class MathExample {
	public static void main(String[] args) {
		double d1 = Math.ceil(5.3);
		// Math클래스의 static final 선언된 상수 사용 클래스명.상수명
		System.out.println(Math.PI);
		// 메소드를 오버라이딩 할 수 없다. static 클래스라 상속하지 않는다.
		System.out.println(Math.max(1.1, 2.3));
		System.out.println(Math.random());
		System.out.println(Math.round(25.77));
		// 난수 얻는 방법 매우 중요
		// Util의 Random 클래스는 static 이 아니기때문에 객체생성해준다.
		Random rd1 = new Random();
		System.out.println(rd1.nextBoolean());
		System.out.println(rd1.nextDouble());
		System.out.println(rd1.nextInt());
		// rd1.nextInt(int n) = int타입의 난수(0<=x<n)를 리턴
		// 소프트웨어 제품번호 인증, 비밀번호 암호화/복호화 에 사용
		System.out.println(rd1.nextInt(100));
	}
}
