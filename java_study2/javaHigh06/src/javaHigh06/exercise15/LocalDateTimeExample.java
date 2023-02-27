package javaHigh06.exercise15;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeExample {
	public static void main(String[] args) {
		
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
		System.out.println("현재시간 : " + now.format(dtf));
		LocalDateTime endTime = LocalDateTime.of(2023, 12, 31, 0, 0, 0);
		
		long remainYear = now.until(endTime, ChronoUnit.YEARS);
		long remainMonth = now.until(endTime, ChronoUnit.MONTHS);
		long remainDay = now.until(endTime, ChronoUnit.DAYS);
		System.out.println(endTime.format(dtf) + " 까지");
		System.out.println(remainDay + "일 남았습니다.");	
	}
}
