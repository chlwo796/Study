package javaHigh06.example07;

import java.util.Calendar;
import java.util.TimeZone;

public class CalendarExample {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();

		int year = now.get(Calendar.YEAR);
		System.out.println(year);
		int month = now.get(Calendar.MONTH) + 1;
		System.out.println(month);
		int day = now.get(Calendar.DATE);
		System.out.println(day);
		int dayOfMonth = now.get(Calendar.DAY_OF_MONTH);
		System.out.println(dayOfMonth);
		// 일=1~토=7
		int weekOfDay = now.get(Calendar.DAY_OF_WEEK);
		System.out.println(weekOfDay);
		String today = null;
		switch (weekOfDay) {
		case 1:
			today = "일";
			break;
		case 2:
			today = "월";
			break;
		case 3:
			today = "화";
			break;
		case 4:
			today = "수";
			break;
		case 5:
			today = "목";
			break;
		case 6:
			today = "금";
			break;
		case 7:
			today = "토";
			break;

		}
		System.out.println(today);

		TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
		
//		String[] timeZoneList = TimeZone.getAvailableIDs();
//		for (int i = 0; i < timeZoneList.length; i++) {
//			System.out.println(timeZoneList[i]);
//		}
		Calendar losNow = Calendar.getInstance(timeZone);	// 설정된 타임존으로 객체생성
		int amPm = now.get(Calendar.AM_PM);
		if(amPm==Calendar.AM) {
			System.out.println("오전");
		}else {
			System.out.println("오후");
		}
		System.out.println(amPm);
		
		
	}
}
