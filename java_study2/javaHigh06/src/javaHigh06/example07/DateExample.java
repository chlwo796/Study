package javaHigh06.example07;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;	// sql�� �ƴ� util�� import

public class DateExample {
	public static void main(String[] args) {
		Date date1 = new Date();
		System.out.println(date1.getDate());	// �����ϸ� �������������!
		System.out.println(date1);
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy�� MM�� dd�� HH:mm:ss");
		String strNow = sdf.format(date1);
		System.out.println(strNow);
		
	}
}