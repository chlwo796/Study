package javaHigh06.example04;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StringExample {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String data = "자바"; // 기본 = UTF-8
		byte[] arr1 = data.getBytes("UTF-8");
		System.out.println(Arrays.toString(arr1));

		String str1 = new String(arr1, "UTF-8");
		System.out.println(str1);

		byte[] arr2 = data.getBytes("EUC-KR");
		System.out.println(Arrays.toString(arr2));

		String str2 = new String(arr2, "EUC-KR");
		System.out.println(str2);

		String data1 = "abc";
		data1 += "def";
		data1 += "ghi";
		// 객체를 계속 생성하지 않고, 재사용한다. 메모리 낭비가 없다.
		StringBuilder data2 = new StringBuilder("abc");
		data2.append("def");

		System.out.println(data2);
		data2.insert(5, "kk");
		System.out.println(data2);

		// StringTokenizer 문자열을 구분자에 의해서 잘라 낼 때, 이용한다.
		String data3 = "홍길동&이수홍,박연수 김자바-이자바";
		// String 클래스 사용하기
		String[] strArray = data3.split("&|,| |-");
		for (int i = 0; i < strArray.length; i++) {
			System.out.println(strArray[i]);
		}
		// StringTokenizer
		String data4 = "홍길동$이수홍@박연수%김자바,이자바";
		StringTokenizer str = new StringTokenizer(data4, ",|&|@|%|$");
		System.out.println(str.countTokens());
		while (str.hasMoreTokens()) {
			String token = str.nextToken();
			System.out.println(token);
		}
		// 포장클래스 Wrapper
		// 기본형 int byte char long float double boolean
		// Wrapper Integer, Byte, Character, Long, Float, Double, Boolean
		// 기본형은 메소드가 없다. -> Wrapper클래스로 선언 후 해당 메소드를 사용
		// int -> Integer 박식
		// Integer -> int 언박싱

		Integer i = 100;
		int a = i.intValue();
		System.out.println(a);
		Integer b = Integer.valueOf(a);

		Double d = 3.4;
		double dd = d.doubleValue();

		float f = 1.2f;
		Float ff = Float.valueOf(f);
	}
}