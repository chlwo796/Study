package singleton;

public class Single {

	private static Single s = new Single();

	private Single() { // private = �ٸ� Ŭ���������� ��� �Ұ�

	}
	private String now() {
		return "2023-01-25";
	}
	
	public static Single getInstance() {
		return s;	// public method�� �ν��Ͻ�ȭ �� ��ü�� �ּ� ����.
	}
}