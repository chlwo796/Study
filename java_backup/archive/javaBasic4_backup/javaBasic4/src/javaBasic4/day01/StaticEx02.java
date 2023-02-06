package javaBasic4.day01;

public class StaticEx02 {
	// Static 변수는 신중히 사용해야 한다. 메모리 효율x
	// 프로그램 생명주기(Life Cycle) 생성 - 활용 - 소멸
	static int a = 100; // 정적변수, 프로그램 시작할 때 생성, 프로그램 종료되면 종료
	static double b = 3.14;
	static String name = "홍길동";

	int c = 200; // 인스턴스 변수, 동적변수 new->생성, 해당 클래스를 벗어나면 사용x
	double d = 5.5;
	String addr = "하남시";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(a + " " + b + " " + name);
		StaticEx02 st02 = new StaticEx02();
		System.out.println(st02.c + " " + st02.d + " " + st02.addr); // 메모리에 올려져 있지 않는 필드
	}

}
