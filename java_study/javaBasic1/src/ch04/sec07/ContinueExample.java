package ch04.sec07;

public class ContinueExample {

	public static void main(String[] args) {
//		���� �ݺ���� �� ¦���� ����ϱ�

		for (int i = 1; i <= 100; i++) {
			if (i % 2 != 0) {
				continue;
			}
			System.out.println(i);
		}
//		continue; ����� ���ÿ� �ش� �߰�ȣ Ż�� �� ������ ���๮ ����x, �ٽ� �ݺ��� ����
//		���� Ȧ��(i%2!=0)������ ���̸� continue;�Ѵ�.
//		continue -> i ���x -> for i++
//		¦�� ��½� continue�� ����ϰ������ Ȧ�� ���ǿ� continue;�ϸ� ¦���� �̱� �����ϴ�.
//		break;= �ٽ� �ݺ���x, continue; = �ٽ� �ݺ���o
	}
}