package javaBasic4.day01;

public class StaticEx04 {

	public static void main(String[] args) {
//		static 선언된 필드와 메소드의 사용
//		다른클래스일지라도 별도 인스턴스화 할 필요없다.
		System.out.println(Student.a + " " + Student.b + " " + Student.c);
		Student.sM();

//		메인에서 static이 아닌 변수, 메소드 호출
		Student st = new Student();
		System.out.println(st.ia + " " + st.ib + " " + st.ic);
		st.iM();

//		getter,setter도 같은 방식
		System.out.println(Student.getA());
		System.out.println(st.getIb());
	}

}

class Student {
	static int a = 10;
	static float b = 1.1f;
	static double c = 5.5;

	public static int getA() {
		return a;
	}

	public static void setA(int a) {
		Student.a = a;
	}

	public static float getB() {
		return b;
	}

	public static void setB(float b) {
		Student.b = b;
	}

	public static double getC() {
		return c;
	}

	public static void setC(double c) {
		Student.c = c;
	}

	public int getIa() {
		return ia;
	}

	public void setIa(int ia) {
		this.ia = ia;
	}

	public float getIb() {
		return ib;
	}

	public void setIb(float ib) {
		this.ib = ib;
	}

	public double getIc() {
		return ic;
	}

	public void setIc(double ic) {
		this.ic = ic;
	}

	int ia = 100;
	float ib = 2.2f;
	double ic = 6.6;

	public static void sM() {
		System.out.println("정적메소드 " + a + b + c);
		System.out.println(Person.name + " " + Person.addr);
	}

	public void iM() {
		System.out.println("인스턴스메소드 " + a + b + c + ia + ib + ic);
	}
}

class Person {
	static String name = "홍길동";
	static String addr = "서울";
}