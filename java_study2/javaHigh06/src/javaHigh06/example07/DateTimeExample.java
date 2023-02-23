package javaHigh06.example07;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateTimeExample {
	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd a HH:mm:ss");
		System.out.println("����ð� : " + now.format(dtf));

		LocalDateTime result1 = now.plusYears(1);
		System.out.println("1�� �� : " + result1.format(dtf));

		LocalDateTime result2 = now.plusMonths(2);
		System.out.println("2�� �� : " + result2.format(dtf));

		LocalDateTime result3 = now.plusDays(20);
		System.out.println("�޿��� : " + result3.format(dtf));

		LocalDateTime result4 = now.plusHours(5);
		int hour = result4.getHour();
		LocalDateTime result5 = now.plusMinutes(10);

		int min = result5.getMinute();
		System.out.println("�˶� : " + hour + "��" + min + "��");

		LocalDateTime result6 = now.plusYears(10);
		System.out.println("�����ڵǴ� �� : " + result6.format(dtf));

		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
		LocalDateTime sdt = LocalDateTime.of(2023, 2, 23, 9, 37, 20);
		System.out.println("������ : " + sdt.format(dtf1));
		LocalDateTime sdt1 = LocalDateTime.of(2023, 2, 28, 23, 59, 59);
		System.out.println("������ : " + sdt1.format(dtf1));

		// ���ϱⰣ : 2023-3-1 ~ 2023-4-30
		// ��¥1 : 2023-3-15 "���ϱⰣ"
		// ��¥2 : 2023-2-20 "���ϱⰣ��"
		// ��¥3 : 2023-5-31 "��������"
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime sdt2 = LocalDateTime.of(2023, 3, 1, 0, 0, 0);
		LocalDateTime sdt3 = LocalDateTime.of(2023, 4, 30, 23, 59, 59);
		System.out.println("���ϱⰣ : " + sdt2.format(dtf2) + " ~ " + sdt3.format(dtf2));

		LocalDateTime date1 = LocalDateTime.of(2023, 3, 15, 0, 0);
		LocalDateTime date2 = LocalDateTime.of(2023, 2, 20, 0, 0);
		LocalDateTime date3 = LocalDateTime.of(2023, 5, 31, 0, 0);

		if (date1.isBefore(sdt3)) {
			System.out.println(date1.format(dtf2));
			System.out.println("���ϱⰣ");
		}
		if (date2.isBefore(sdt3)) {
			System.out.println(date2.format(dtf2));
			System.out.println("���ϱⰣ ��");
		}
		if (date3.isAfter(sdt3)) {
			System.out.println(date3.format(dtf2));
			System.out.println("��������");
		}

		// �Է¹޾Ƽ� �غ���
		Scanner sc = new Scanner(System.in);
		System.out.print("�⵵");
		int year = sc.nextInt();
		System.out.println();
		System.out.print("��");
		int month = sc.nextInt();
		System.out.println();
		System.out.print("��");
		int day = sc.nextInt();
		System.out.println();

		LocalDateTime cudate = LocalDateTime.of(year, month, day, 0, 0, 0);
		if (cudate.isBefore(sdt3)) {
			System.out.println("���ϱⰣ");
		}
		else if (cudate.isAfter(sdt3)) {
			System.out.println("���ϱⰣ����");
		}
		else if (cudate.isBefore(sdt2)) {
			System.out.println("���ϱⰣ��");
		}
	}
}