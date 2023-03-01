package javaChap12.exercise15;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {
	public static void main(String[] args) {
		LocalDateTime startDate = LocalDateTime.now();
		LocalDateTime endDate = LocalDateTime.of(2023, 12, 31, 0, 0, 0);

		long remainDays = startDate.until(endDate, ChronoUnit.DAYS);

		System.out.println("남은 일수 : " + remainDays);

	}
}
