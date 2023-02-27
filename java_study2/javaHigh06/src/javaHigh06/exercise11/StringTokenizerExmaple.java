package javaHigh06.exercise11;

import java.util.StringTokenizer;

public class StringTokenizerExmaple {
	public static void main(String[] args) {
		String str = "���̵�,�̸�,�н�����";
		StringTokenizer st = new StringTokenizer(str, ",");

		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println(token);
		}
	}
}
