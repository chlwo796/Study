package ch03.sec08;

public class BitLogicExample {

	public static void main(String[] args) {
		// ��Ʈ ��������. 2������ �����Ѵ�. �� �ڸ��� ��. 1 = true, 0 = false
		// & = �� �ڸ��� ��� 1�� ��� true
		// | = �� �� �ϳ��� 1�� ��� true
		// ^ = ���� �ٸ��ٸ� true
		// ~ = �� �ڸ��� ��� 0�� ��� true. & �ݴ뿬��.
		// true, false�� ���� 0�� 1�� �ջ��� �ٽ� 10������ ��ȯ�Ѵ�.

		System.out.println("45 & 25 = " + (45 & 25));
		System.out.println("45 | 25 = " + (45 | 25));
		System.out.println("45 ^ 25 = " + (45 ^ 25));
		System.out.println("~45 = " + (~45));
		System.out.println("-----------------------");

		// ���� �ٸ� ������Ÿ���� ���� ���α׷� ���̿� �����͸� �ְ�޴� ���
		// ��Ʈ�������ڰ� �ʿ��ϴ�.

		byte receiveData = -128; // C����� �������� 0~255������ ���
		int unsignedInt1 = receiveData & 255; // java byteŸ���� ������ -128�� �������� 255�� ������ ���ָ�
		System.out.println(unsignedInt1); // C����� ���������� ��밡���� ������������ �����ϴ�

		int unsignedInt2 = Byte.toUnsignedInt(receiveData); // java api�� �̿��� �ڵ� ����
		System.out.println(unsignedInt2);

		int test = 136;
		byte btest = (byte) test;
		System.out.println(btest); // Overflow ����Ȯ��

	}

}
