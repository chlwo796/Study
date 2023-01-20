package ch03.sec01;

import java.util.Scanner;

public class OperandEx01 {

	public static void main(String[] args) {
		// 연산자 ++a 전위 단항 연산자, a-- 후위 단항 연산자
		// 연산자2 (a=a+1 a+=1) (a=a+2 a+=2) (a=a+b a+=b) (a=a-10 a-=10) (a=a*b a*=b)
		int a = 10;
		System.out.println(a + 1); // 11을 출력

		// a = a+1;
		// a++;
		// ++a;
		System.out.println(a);

		// a = a-1;
		// a--;
		// --a;
		// a--;
		System.out.println(a); // 9출력하기

		int b;
		// b변수에 11을 넣어서 출력
		// b= a++ 하면 10이 출력됨
		// b = ++a;
		// b = ++a는 a = a+1, b = a, 11 10
		// b = a++;
		// b = a++는 b = a, a = a+1, 10 11
		b = a++;
		System.out.println(a);
		System.out.println(b);

		int d = 20;
		System.out.println(++d); // d=d+1 출력 21
		System.out.println(d++); // 출력하고 d=d+1
		System.out.println(d);

		// 연산자2
		int e = 10;
		// e = e-8;
		e -= 8;
		System.out.println(e);

		// 연산자3
		// 나누기 25/5=5 25/4 = 6.25
		int v1 = 25;
		int v2 = 4;

		System.out.println((double) v1 / v2); // 1. 자료형을 실수로 만들기

		v1 *= 100; // v1 = v1*100;
		v2 *= 100; // v2 = v2*100;

		System.out.println((v1 / v2) / 100);
		// 2. 자료형은 정수로 그대로 하고 2500/500 = 625를 구하고 625/100 출력.

		// >>우측 쉬프트연산자, <<좌측 쉬프트 연산자 2의 배수로 곱하거나 더할때
		int v3 = 0b1011; // 10진수 11
		// v3 = v3 << 2; //2방향으로 2bit 밀어준다. 2의 배수를 곱하거나 나눌때
		v3 = v3 >> 2; // 원래숫자 /2^2 11/4
		System.out.println(v3); // 1011

		// 관계연산자 > 초과, >= 이상, < 미만, <= 이하, ==같다, != 같지 않다
		int v4 = 100;
		System.out.println(v4 != 200); // true or false

		// 비트연산자 - 과학분야, 전자분야 주로 사용
		int v5 = 0b01011; // 1 true, 0 false
		int v6 = 0b10111;
		System.out.println(Integer.toBinaryString(v5 & v6)); // 00011, 참거짓 and
		System.out.println(Integer.toBinaryString(v5 | v6)); // | or
		System.out.println(Integer.toBinaryString(v5 ^ v6)); // ^ xor, 다르면 1 같으면 0

		// 대입연산자 '=' 우변에 있는 값을 좌변(변수만 나와야 함)에 넣으세요.
		int v7 = 100;
		// int 200 = v7; //실행불가
		int v8 = v2 + 200;
		// int v2 + 200 = v8; //실행불가

		// 삼항연산자 (조건)? 참:거짓
		int v9 = 10;
		System.out.println((v9==10) ? "합격" : "불합격");
		
		String type = "A";
		String result;
		result = (type.equals("B")) ? "VIP고객입니다" : "일반고객입니다";
		System.out.println(result);
		
		//문제 숫자 변수에 50을 입력하고 25이상이면 "포인트 대상" 아니면 "포인트 대상이 아닙니다"
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요==>");
		int number = sc.nextInt();
		String result1;
		result1 = (25<=number) ? "포인트 대상" : "포인트 대상이 아닙니다";
		System.out.println(result1);
		
		//문제 문자형 변수에 "자바"라고 입력하고 자바가 아니면 "B교실,C교실입니다." 자바면 "A교실입니다."라고 출력하기
		
		System.out.print("어떤 수업입니까?");
		String className = sc.nextLine();
		String result2;
		result2 = (className.equals("자바")) ? "B교실, C교실입니다" : "A교실입니다";
		
		
	}

}
