package ch05.day05;

import java.util.Calendar;

public class WeekEx197page {

	public static void main(String[] args) {
//		������ �ǽ� ����, ������ Enumeration type = ������� �����͸� �������� �� �ִ�.
//		�Է� �����Ϳ� ��µ����͸� ���� �����ͷ� �����Ͽ� ��Ÿ�� �Ÿ� ���� �ְ�, ����, ���� �ð� ���� Ÿ������ �ϸ� �����ϴ�.
		Week today = null;
		Calendar cal = Calendar.getInstance(); // �޷°� ���õ� Ŭ������ ����� �� �ִ�.
		int week = cal.get(Calendar.DAY_OF_WEEK); // ��~�� = 1~7 return
		System.out.println(week);

		today = Week.WEDNESDAY;
		System.out.println(today);

		today = null;

		if (week == 4) {
			today = Week.WEDNESDAY;
			System.out.println(today);
		}
//		�ݺ������ε� ������ �� ����! 1~7���� �迭!
		if (week == 7)
			System.out.println("���� ���� �Ա�");
		today = Week.SATURDAY;
		if (today == Week.SATURDAY)
			System.out.println("���� ���� �Ա�");

		LoginResult login = null;

		login = LoginResult.LOGIN_SUCCESS;

		login = LoginResult.LOGIN_FAILED;

//		login = LoginResult.LOGGING;	// Enum�� ���ǵǾ����� �ʴ�. ���Ұ�
		
		
	}

}
