package javaMid5.ex08;

public class SnowTireExample {
	public static void main(String[] args) {
//		chap06.ex08
		SnowTire snowTire = new SnowTire();
		Tire tire = snowTire;

		snowTire.run();
		tire.run(); // �Ѵ� �����Ű�����..�����!

		tire = new Tire(); // �ڽ��� �ּҷ� ��üȭ�ؼ� �ڽ��� �޼ҵ带 ����Ѵ�.
		tire.run();
	}
}
