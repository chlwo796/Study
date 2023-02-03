package javaMid6.ex01;

public class OutterAMain {
	public static void main(String[] args) {
		OutterA outterA = new OutterA();

		OutterA.InnerA innerA = outterA.new InnerA();

		innerA.methodInnerA(); // OutterA, InnerA의 정수 a의 흐름을 다시보자.

//		inner class는 outter의 member를 모두 사용할 수 있고, outter에서 inner는 제한된다.
//		클래스 중첩은 보통 외부에서 접근하지 못하도록 해야하는 class를 inner로 지정해서 사용한다.

	}
}