package tempMemo;

public class A {

	private static A a = new A();	// Ŭ���� �ڽ��� Ÿ������ private �ʵ带 ����

	private A() {
//		private ����� class A�� ������. �ܺο��� ��ü���� �� �� ����.
	}

	public static A getInstance() {
		return a;	// �ڽ��� �ּҸ� ����. �ܺο��� �޼ҵ常 ȣ���ذ���. �޸� ȿ���� ����
	}
}