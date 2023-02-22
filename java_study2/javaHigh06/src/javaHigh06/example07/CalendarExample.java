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
		// ��=1~��=7
		int weekOfDay = now.get(Calendar.DAY_OF_WEEK);
		System.out.println(weekOfDay);
		String today = null;
		switch (weekOfDay) {
		case 1:
			today = "��";
			break;
		case 2:
			today = "��";
			break;
		case 3:
			today = "ȭ";
			break;
		case 4:
			today = "��";
			break;
		case 5:
			today = "��";
			break;
		case 6:
			today = "��";
			break;
		case 7:
			today = "��";
			break;

		}
		System.out.println(today);

		TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
		
//		String[] timeZoneList = TimeZone.getAvailableIDs();
//		for (int i = 0; i < timeZoneList.length; i++) {
//			System.out.println(timeZoneList[i]);
//		}
		Calendar losNow = Calendar.getInstance(timeZone);	// ������ Ÿ�������� ��ü����
		int amPm = now.get(Calendar.AM_PM);
		if(amPm==Calendar.AM) {
			System.out.println("����");
		}else {
			System.out.println("����");
		}
		System.out.println(amPm);
		
		
	}
}
