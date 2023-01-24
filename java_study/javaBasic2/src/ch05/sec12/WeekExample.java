package ch05.sec12;

import java.util.Calendar;

public class WeekExample {

	public static void main(String[] args) {
//		Enum 실습
//		Week today = Week.SUNDAY;
//		System.out.println(today == Week.SUNDAY); // 열거타입의 참조확인 가능

		Week today = null;

		Calendar cal = Calendar.getInstance();

		int week = cal.get(Calendar.DAY_OF_WEEK);

		switch (week) {
		case 1:
			today = Week.SUNDAY;
			break;
		case 2:
			today = Week.MONDAY;
			break;
		case 3:
			today = Week.TUESDAY;
			break;
		case 4:
			today = Week.WEDNESDAY;
			break;
		case 5:
			today = Week.THURSDAY;
			break;
		case 6:
			today = Week.FRIDAY;
			break;
		case 7:
			today = Week.SATURDAY;
			break;
		}
		System.out.println(today);
		if(today == Week.SUNDAY) {
			System.out.println("일요일");
		}else System.out.println("다른요일");
	}
}