package javaMid7.ex01;

public class OutterEx01 {
	public static void main(String[] args) {
//		OutterA�� �ν��Ͻ� ��� Ŭ���� ��üȭ �ϱ�
		OutterA o = new OutterA();
		OutterA.InnerA ia = o.new InnerA();

//		OutterB ������� Ŭ���� ��üȭ �ϱ�
		OutterB.InnerB oi = new OutterB.InnerB();
		oi.ia = 100;
		oi.iam();
//		static �پ��ִ� ������� Ŭ������.������� Ŭ������.�޼ҵ��()
		OutterB.InnerB.sia = 200;
		OutterB.InnerB.siaM();
	}
}
