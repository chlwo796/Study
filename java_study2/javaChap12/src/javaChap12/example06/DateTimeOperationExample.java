package javaChap12.example06;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeOperationExample {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");
		System.out.println(now.format(dtf));
		
		LocalDateTime result1 = now.plusYears(1);
		System.out.println("1�� ���ϱ� : " + result1.format(dtf));
		
		LocalDateTime result2 = now.minusHours(1);
		System.out.println("1�ð� ���� : " + result2.format(dtf));
		
		LocalDateTime result3 = now.plusDays(6);
		System.out.println("6�� ���ϱ� : " + result3.format(dtf));
	}
}
