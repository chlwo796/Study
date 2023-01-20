package ch05.day05;

import java.util.Calendar;

public class WeekEx197page {

	public static void main(String[] args) {
//		열거형 실습 예제, 열거형 Enumeration type = 사용중인 데이터를 한정지을 수 있다.
//		입력 데이터와 출력데이터를 일정 데이터로 한정하여 오타를 거를 수도 있고, 요일, 계절 시간 등의 타입으로 하면 용이하다.
		Week today = null;
		Calendar cal = Calendar.getInstance(); // 달력과 관련된 클래스를 사용할 수 있다.
		int week = cal.get(Calendar.DAY_OF_WEEK); // 일~월 = 1~7 return
		System.out.println(week);

		today = Week.WEDNESDAY;
		System.out.println(today);

		today = null;

		if (week == 4) {
			today = Week.WEDNESDAY;
			System.out.println(today);
		}
//		반복문으로도 가능할 것 같다! 1~7까지 배열!
		if (week == 7)
			System.out.println("저녁 같이 먹기");
		today = Week.SATURDAY;
		if (today == Week.SATURDAY)
			System.out.println("저녁 같이 먹기");

		LoginResult login = null;

		login = LoginResult.LOGIN_SUCCESS;

		login = LoginResult.LOGIN_FAILED;

//		login = LoginResult.LOGGING;	// Enum에 정의되어있지 않다. 사용불가
		
		
	}

}
