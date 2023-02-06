package javaMid7.ex02;

public class A {

	class B {
		int sum = 0;

		void print() {
			for (int i = 0; i <= 100; i++) {
				sum = sum + i;
			}
			System.out.println(sum);
		}
	}
}
