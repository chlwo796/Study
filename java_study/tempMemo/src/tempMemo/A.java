package tempMemo;

public class A {

	private static A a = new A();	// 클래스 자신의 타입으로 private 필드를 선언

	private A() {
//		private 선언된 class A의 생성자. 외부에서 객체생성 할 수 없다.
	}

	public static A getInstance() {
		return a;	// 자신의 주소를 리턴. 외부에서 메소드만 호출해간다. 메모리 효율성 증대
	}
}