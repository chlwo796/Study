package javaHigh09.example01;

public class LambdaEx01 {
	public static void main(String[] args) {
		// �⺻ ���
		CalculImpl c1 = new CalculImpl();
		c1.c();

		// ���2 = �͸�����ü

		Calculable c2 = new Calculable() {

			@Override
			public void c() {
				System.out.println("�͸�����ü");

			}
		};
		c2.c();

		// ���3 ���ٽ�
		Calculable c3 = () -> System.out.println("���ٽ�ǥ��");
		c3.c();
	}
}