package javaHigh06.example04;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class StringExample {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String data = "�ڹ�"; // �⺻ = UTF-8
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
		// ��ü�� ��� �������� �ʰ�, �����Ѵ�. �޸� ���� ����.
		StringBuilder data2 = new StringBuilder("abc");
		data2.append("def");

		System.out.println(data2);
		data2.insert(5, "kk");
		System.out.println(data2);

		// StringTokenizer ���ڿ��� �����ڿ� ���ؼ� �߶� �� ��, �̿��Ѵ�.
		String data3 = "ȫ�浿&�̼�ȫ,�ڿ��� ���ڹ�-���ڹ�";
		// String Ŭ���� ����ϱ�
		String[] strArray = data3.split("&|,| |-");
		for (int i = 0; i < strArray.length; i++) {
			System.out.println(strArray[i]);
		}
		// StringTokenizer
		String data4 = "ȫ�浿$�̼�ȫ@�ڿ���%���ڹ�,���ڹ�";
		StringTokenizer str = new StringTokenizer(data4, ",|&|@|%|$");
		System.out.println(str.countTokens());
		while (str.hasMoreTokens()) {
			String token = str.nextToken();
			System.out.println(token);
		}
		// ����Ŭ���� Wrapper
		// �⺻�� int byte char long float double boolean
		// Wrapper Integer, Byte, Character, Long, Float, Double, Boolean
		// �⺻���� �޼ҵ尡 ����. -> WrapperŬ������ ���� �� �ش� �޼ҵ带 ���
		// int -> Integer �ڽ�
		// Integer -> int ��ڽ�

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