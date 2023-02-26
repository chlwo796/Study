package javaChap12.example03;

import java.util.StringTokenizer;

public class StringTokenizerExample {
	public static void main(String[] args) {
		String str1 = "ȫ�浿%�̼�ȫ,�ڿ���";
		String[] names = str1.split("%|,");

		for (String str : names) {
			System.out.println(str);
		}
		String str2 = "ȫ�浿$,�̼�ȫ$**�ڿ���";
		StringTokenizer st = new StringTokenizer(str2, "$|,|*");
		int count = st.countTokens();
		System.out.println(count);
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
		System.out.println(st.countTokens());
	}
}
