package ch02.sec11;

public class VariableScopeExample {

	public static void main(String[] args) {
		// ���� ��� ����
		// int v1 = 15;
		// if(v1>15) {
		// int v2 = v1-10; // if���� {} �ȿ��� ����� ���� v2�� �ش� �߰�ȣ{}������ ����� �����ϴ�.
		// }
		// int v3 = v1 + v2 +5;

		// System.out.println(v1); // �ܺ� main method{}���� ����� ���๮�� v2��� ������ �������� �ʴ´�.
		// method block ��ü���� ����ϰ� ������ method block ù�Ӹ��� �����ϴ� ���� ����.
		int v1 = 15;
		int v2 = v1 - 10;
		int v3 = v1 + v2 + 5;

		if (v1 > 10) {
			v2 = v1 + 5;
		}
		System.out.println(v3);		//���������� ����ǵ��� �ٽ� �ڵ���.
	}

}
