package javaChap12.example10;

public class Service {
	@PrintAnnotation	// default 속성대로 적용
	public void method1() {
		System.out.println("실행내용1");
	}

	@PrintAnnotation("*")	// value에 값만 적용 = value 생략가능
	public void method2() {
		System.out.println("실행내용2");
	}

	@PrintAnnotation(value = "#", number = 20)	// number 속성도 변경 = value 생략불가
	public void method3() {
		System.out.println("실행내용3");
	}
}
