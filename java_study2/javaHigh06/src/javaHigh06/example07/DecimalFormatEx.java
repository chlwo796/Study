package javaHigh06.example07;

import java.text.DecimalFormat;

public class DecimalFormatEx {
	public static void main(String[] args) {
		// 소수점 16째자리 까지만 출력(반올림)
		double d1 = 0.1234567891234565678989213;
		System.out.println(d1);
		double d2 = 10;
		// 소수점 3자리
		// # 자리에 숫자가 들어오지 않으면 공백
		DecimalFormat df1 = new DecimalFormat("#.###");
		System.out.println(df1.format(d1));
		
		System.out.println(df1.format(d2));
		DecimalFormat df2 = new DecimalFormat("0.00");
		System.out.println(df2.format(d1));
		// 한번 더 보기, 통화기호
		DecimalFormat df3 = new DecimalFormat("\u00A4#,###");
		System.out.println(df3.format(1234567.89));
	}
}
