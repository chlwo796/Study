package javaMid1.ch07;

public class D {

	int a;

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public D() {
		this(100);	// �ڽ��� �ٸ� �޼ҵ� ȣ��(�޼ҵ�����ε�), �ݵ�� ù°��
		System.out.println("DŬ������ �⺻������");
	}
	public D(int a) {
		this.a = a;
		System.out.println("DŬ������ �����������");
	}
}