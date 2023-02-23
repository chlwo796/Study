package javaHigh06.example07;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateTimeExample {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");
		System.out.println("현재시간 : " + now.format(dtf));

		LocalDateTime result1 = now.plusYears(1);
		System.out.println("1년 후 : " + result1.format(dtf));

		LocalDateTime result2 = now.plusMonths(2);
		System.out.println("2달 후 : " + result2.format(dtf));

		LocalDateTime result3 = now.plusDays(20);
		System.out.println("급여일 : " + result3.format(dtf));

		LocalDateTime result4 = now.plusHours(5);
		int hour = result4.getHour();
		LocalDateTime result5 = now.plusMinutes(10);

		int min = result5.getMinute();
		System.out.println("알람 : " + hour + "시" + min + "분");

		LocalDateTime result6 = now.plusYears(10);
		System.out.println("백억부자되는 해 : " + result6.format(dtf));

		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
		LocalDateTime sdt = LocalDateTime.of(2023, 2, 23, 9, 37, 20);
		System.out.println("시작일 : " + sdt.format(dtf1));
		LocalDateTime sdt1 = LocalDateTime.of(2023, 2, 28, 23, 59, 59);
		System.out.println("종료일 : " + sdt1.format(dtf1));

		// 세일기간 : 2023-3-1 ~ 2023-4-30
		// 날짜1 : 2023-3-15 "세일기간"
		// 날짜2 : 2023-2-20 "세일기간전"
		// 날짜3 : 2023-5-31 "세일종료"
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime sdt2 = LocalDateTime.of(2023, 3, 1, 0, 0, 0);
		LocalDateTime sdt3 = LocalDateTime.of(2023, 4, 30, 23, 59, 59);
		System.out.println("세일기간 : " + sdt2.format(dtf2) + " ~ " + sdt3.format(dtf2));

		LocalDateTime date1 = LocalDateTime.of(2023, 3, 15, 0, 0);
		LocalDateTime date2 = LocalDateTime.of(2023, 2, 20, 0, 0);
		LocalDateTime date3 = LocalDateTime.of(2023, 5, 31, 0, 0);

		if (date1.isBefore(sdt3)) {
			System.out.println(date1.format(dtf2));
			System.out.println("세일기간");
		}
		if (date2.isBefore(sdt3)) {
			System.out.println(date2.format(dtf2));
			System.out.println("세일기간 전");
		}
		if (date3.isAfter(sdt3)) {
			System.out.println(date3.format(dtf2));
			System.out.println("세일종료");
		}

		// 입력받아서 해보기
		Scanner sc = new Scanner(System.in);
		System.out.print("년도");
		int year = sc.nextInt();
		System.out.println();
		System.out.print("월");
		int month = sc.nextInt();
		System.out.println();
		System.out.print("일");
		int day = sc.nextInt();
		System.out.println();

		LocalDateTime cudate = LocalDateTime.of(year, month, day, 0, 0, 0);
		if (cudate.isBefore(sdt3)) {
			System.out.println("세일기간");
		}
		else if (cudate.isAfter(sdt3)) {
			System.out.println("세일기간종료");
		}
		else if (cudate.isBefore(sdt2)) {
			System.out.println("세일기간전");
		}
	}
}