package javaHigh07.example01;

public class GenericEx04 {
	public static void main(String[] args) {
		A<String> a = new A<String>();
		AA<Integer, Boolean> aa = new AA<Integer, Boolean>();
	}
}

class A<I> {

}

class AA<I, J> extends A<I> {
	// 자식은 부모의 타입,제네릭 그대로 물려받아야 한다.
	// 혹은 추가로 지정해줄 수 있다.
}

class AAA<I, J, K> extends AA<I, J> {

}