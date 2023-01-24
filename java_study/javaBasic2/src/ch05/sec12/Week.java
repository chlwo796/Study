package ch05.sec12;

public enum Week {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY

//	열거 상수는 알파벳 대문자로 정의하고, 여러 단어일 경우 사이를'_'언더바로 연결하는것이 관례이다.

}

enum LoginResult {
	LOGIN_SUCCESS, LOGIN_FAILED
}

class Declaration {
	Week today; // 'today'라는 변수를 Week 이라는 열거타입으로 선언
	Week reservationDay; // 'reservationDay'변수를 Week 이라는 열거타입으로 선언
	LoginResult loginStatus; // 'loginStatus' 변수를 LoginResult 열거타입으로 선언

	void Declaraion() {
		today = Week.SUNDAY;
		Week birthDay = null; // 열거타입은 참조타입으로 null 대입 가능
	}
}