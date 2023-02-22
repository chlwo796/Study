package javaHigh06.example07;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;	// sql이 아닌 util로 import

public class DateExample {
	public static void main(String[] args) {
		Date date1 = new Date();
		System.out.println(date1.getDate());	// 가능하면 사용하지마세요!
		System.out.println(date1);
		
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
		String strNow = sdf.format(date1);
		System.out.println(strNow);
		
	}
}