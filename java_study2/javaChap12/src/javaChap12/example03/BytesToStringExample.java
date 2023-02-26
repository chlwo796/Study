package javaChap12.example03;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class BytesToStringExample {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		String data = "자바";
		// 인코딩
		byte[] arr1 = data.getBytes("UTF-8"); // 기본 = UTF-8, .getBytes("UTF-8");

		System.out.println(Arrays.toString(arr1));
		// 디코딩
		String str1 = new String(arr1);
		System.out.println(str1);

		byte[] arr2 = data.getBytes("EUC-KR");
		System.out.println(Arrays.toString(arr2));

		String str2 = new String(arr2);
		System.out.println(str2);
		String korStr = "자바";

		// 인코딩 변환
		String charset[] = { "utf-8", "euc-kr", "ksc5601", "iso-8859-1", "8859_1", "ascii" };

		for (String before : charset) {
			for (String after : charset) {
				if (!before.equals(after)) {
					System.out.println(before + " -> " + after + " = " + new String("자바".getBytes(before), after));
				}
			}
		}
	}
}