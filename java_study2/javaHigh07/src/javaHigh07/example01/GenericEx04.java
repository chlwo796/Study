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
	// �ڽ��� �θ��� Ÿ��,���׸� �״�� �����޾ƾ� �Ѵ�.
	// Ȥ�� �߰��� �������� �� �ִ�.
}

class AAA<I, J, K> extends AA<I, J> {

}