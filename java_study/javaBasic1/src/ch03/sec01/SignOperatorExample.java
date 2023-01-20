package ch03.sec01;

public class SignOperatorExample {

	public static void main(String[] args) {
		// 부호 연산자
		
		int x = 100;
		x = -x;
		System.out.println(x);
		
		byte b = 20;
		int y = -b;		//정수타입 연산의 결과는 int 타입. 부호를 변경하는 것도 연산이다.
		System.out.println(y);

	}

}
