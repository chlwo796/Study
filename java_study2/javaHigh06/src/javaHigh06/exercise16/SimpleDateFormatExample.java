package javaHigh06.exercise16;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatExample {
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� E���� HH�� mm��");
		String now = sdf.format(new Date());
		System.out.println(now);
	}
}