package b;

public class B {
//	(default)�� �ش� ��Ű�������� ���
//	A��Ű������ ����Ϸ��� public ���������ڸ� ����ؾ� �Ѵ�.
	
//	static int sb = 100;	
//	int ib = 200;
	
//	private static int sb = 100;	// private = b��Ű�������� ��� ����
//	private int ib = 200;
	
//	�ǹ���� private field, public method
	private static int sb = 100;
	private int ib = 200;
	
	public static int getSb() {
		return sb;
	}
	public static void setSb(int sb) {
		B.sb = sb;
	}
	public int getIb() {
		return ib;
	}
	public void setIb(int ib) {
		this.ib = ib;
	}
}