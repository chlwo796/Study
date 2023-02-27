package javaChap12.example07;

import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class DecimalFormatExample {
	public static void main(String[] args) throws UnsupportedEncodingException {
		double num = 1234567.89;
		
		DecimalFormat df;

		df = new DecimalFormat("#,###");
		System.out.println(df.format(num));
		
		df = new DecimalFormat("#,###.00");
		System.out.println(df.format(num));
//		String won = new String("\u00A4".getBytes(),"iso4217");
//		System.out.println(won);
		df = new DecimalFormat("\u00A4 #,###");
		String strNum = df.format(num);
		System.out.println(strNum);
		String newStr = new String(strNum.getBytes());
		System.out.println(newStr);
		// 왜 통화기호가 출력이 안되는것일까..?
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.KOREA);
		System.out.println(nf.format(num));
	}
}
