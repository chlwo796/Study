package ch02.sec02;

public class LongExample {

	public static void main(String[] args) {
		
		long v1 = 10;		// long타입은 숫자가 큰 프로그램에서 사용한다. 과학, 은행 등.
		long v2 = 10L;
		// long v3 = 10000000000000;		// 기본적으로 컴파일러는 정수 literal을 int타입으로 간주한다.
		long v4 = 10000000000000L;
		
		// Unresolved compilation problem: 
		// The literal 10000000000000 of type int is out of range
		// 이 컴파일오류는 긴 숫자를 long 타입이 아닌 int 타입으로 간주하여 생기는 오류.
		// 뒤에 L을 붙혀 long타입이라고 지정해야한다.
		
		System.out.println(v1);
		System.out.println(v2);
		// System.out.println(v3);
		System.out.println(v4);

	}

}
