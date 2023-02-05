package javaMid5.ex08;

public class SnowTireExample {
	public static void main(String[] args) {
//		chap06.ex08
		SnowTire snowTire = new SnowTire();
		Tire tire = snowTire;

		snowTire.run();
		tire.run(); // 둘다 같은거같은데..맞췄다!

		tire = new Tire(); // 자신의 주소로 객체화해서 자신의 메소드를 출력한다.
		tire.run();
	}
}
