package javaMid7.ex02;

public class Main {
	public static void main(String[] args) {
		A a = new A();
		A.B ab = a.new B();

		ab.print();

		C.D.print();

		C.D.printA();
	}
}