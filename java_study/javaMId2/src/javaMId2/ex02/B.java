package javaMId2.ex02;

public class B {
	void method() {
		A a = new A();
		a.value = 300;	// 아무관계 아니지만, protected = 같은 패키지의 데이터를 공용 가능하다.
	}
}
