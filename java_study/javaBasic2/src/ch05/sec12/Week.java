package ch05.sec12;

public enum Week {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY

//	���� ����� ���ĺ� �빮�ڷ� �����ϰ�, ���� �ܾ��� ��� ���̸�'_'����ٷ� �����ϴ°��� �����̴�.

}

enum LoginResult {
	LOGIN_SUCCESS, LOGIN_FAILED
}

class Declaration {
	Week today; // 'today'��� ������ Week �̶�� ����Ÿ������ ����
	Week reservationDay; // 'reservationDay'������ Week �̶�� ����Ÿ������ ����
	LoginResult loginStatus; // 'loginStatus' ������ LoginResult ����Ÿ������ ����

	void Declaraion() {
		today = Week.SUNDAY;
		Week birthDay = null; // ����Ÿ���� ����Ÿ������ null ���� ����
	}
}