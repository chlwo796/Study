package javaChap12.example06;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeCompareExample {
	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");

		LocalDateTime startDateTime = LocalDateTime.of(2023, 1, 1, 0, 0, 0);

		System.out.println("������ : " + startDateTime.format(dtf));

		LocalDateTime endDateTime = LocalDateTime.of(2023, 12, 31, 0, 0, 0);

		System.out.println("������ : " + endDateTime.format(dtf));
		
		if(startDateTime.isBefore(endDateTime)) {
			System.out.println("�������Դϴ�.");
		}else if(startDateTime.isEqual(endDateTime)) {
			System.out.println("�����մϴ�.");
		}else if(startDateTime.isAfter(endDateTime)) {
			System.out.println("�����߽��ϴ�.");
		}
		long remainYear = startDateTime.until(endDateTime, ChronoUnit.YEARS);
		long remainMonth = startDateTime.until(endDateTime, ChronoUnit.MONTHS);
		long remainDay = startDateTime.until(endDateTime, ChronoUnit.DAYS);
		long remainHour = startDateTime.until(endDateTime, ChronoUnit.HOURS);
		long remainMinute = startDateTime.until(endDateTime, ChronoUnit.MINUTES);
		long remainSecond = startDateTime.until(endDateTime, ChronoUnit.SECONDS);
		
		System.out.println("���� �� : " + remainYear);
		System.out.println("���� �� : " + remainMonth);
		System.out.println("���� �� : " + remainDay);
		System.out.println("���� �ð� : " + remainHour);
		System.out.println("���� �� : " + remainMinute);
		System.out.println("���� �� : " + remainSecond);
	}
}
