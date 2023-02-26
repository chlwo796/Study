package javaChap12.example06;

import java.util.Calendar;
import java.util.TimeZone;

public class LosAngelesExample {
	public static void main(String[] args) {
		TimeZone timeZone = TimeZone.getTimeZone("America/Los_Angeles");
		Calendar now = Calendar.getInstance(timeZone);

		int amPm = now.get(Calendar.AM);
		String strAmPm = null;
		if (amPm == Calendar.AM) {
			strAmPm = "����";
		} else {
			strAmPm = "����";
		}
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);

		System.out.println(strAmPm);
		System.out.println(hour + "��");
		System.out.println(minute + "��");
		System.out.println(second + "��");

	}
}
