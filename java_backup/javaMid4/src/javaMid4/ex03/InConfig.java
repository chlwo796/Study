package javaMid4.ex03;

public interface InConfig {
	void i1();	// �ַ� �߻�޼ҵ�

//	��� �Է� ����

	static final double PI = 3.14;
	static final boolean OK = true;
	static final int COMPUTOR_PRICE = 2000000;
	static final int PRINTER_PRICE = 50000;

//	default method = �ڹ� 1.8 ���� �߰� �Ʒ� �޼ҵ���� ���� {}����� ����� �� �ִ�.
	default void di1() {
//		interface���� default method���� ����� ����غ� �� �ִ�.
//		overriding ���ʿ�.
	}
	default int dd1() {
		return 0;
	}
//	static method
	static void sm() {
		
	}
//	private method
	private void pri() {
		
	}
}
