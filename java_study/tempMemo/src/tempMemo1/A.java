package tempMemo1;

public class A {
	public A() {
//		A의 기본생성자
	}

	B b = new B() {
//		public B() {
//			super();
//			익명자식객체이므로 부모타입의 생성자만 생성할 수 있다. 생성불가
//			메소드만 선언 가능하다.
//		}

		@Override
		void methodB() {
			System.out.println("B클래스의 익명자식객체");
		}
	};
}
