package tempMemo1;

public class A {
	private int fieldA;

	void methodA() {
		class B {
			int fieldB;

			void methodB() {
				fieldA = +1;
				fieldA = fieldA + fieldB;
				System.out.println(fieldA);
			}

		}
		B b = new B();
		b.fieldB = +3;
		b.methodB();
		
	}
}