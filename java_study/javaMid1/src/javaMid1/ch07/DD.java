package javaMid1.ch07;

public class DD extends D {
	int aa;

	public int getAa() {
		return aa;
	}

	public void setAa(int aa) {
		this.aa = aa;
	}

	public DD() {
//		super(200);	// super = �θ������ ȣ��, �θ��� ����������� ȣ�� �� �θ��� �⺻������ �н�
//		�θ�Ŭ������ inputŸ���� �´� �����ڸ� ȣ��
		System.out.println("�̰��� DDŬ������ �⺻������");
	}
	public DD(int aa) {
		System.out.println("DD ����� ������");
	}
}
