package ch04.sec07;

public class BreakOutterExample {

	public static void main(String[] args) {
//		��ø�� �ݺ����� break;
		System.out.println((int) 'A');
		System.out.println((int) 'Z'); // A~Z = 65~90
		System.out.println((int) 'a');
		System.out.println((int) 'z'); // a~z = 97~122
		System.out.println((int) 'g');

		Outter: for (char i = 'A'; i <= 'Z'; i++) {
			for (char j = 'a'; j <= 'z'; j++) {
				System.out.println(i + " - " + j);
				if (j == 'g') {

					break Outter;
				}

			}
		}
//		for������ char�� ���������� ������ �ٷ� �����ϴ�.
//		���ο� break;�� ��ø���� �ʰ� �ѹ��� �����Ϸ��� 
//		�����ϰ� ���� ���� �ݺ����� `name: `���� break name;
	}

}
