package javaHigh06.exercise17;

import java.util.regex.Pattern;

public class PatternMatcherExample {
	public static void main(String[] args) {
		String id = "2Angel1004";
		String regExp = "[a-zA-Z]\\w{7,11}";
		boolean isMatch = Pattern.matches(regExp, id);
		boolean a = id.matches(regExp);
		System.out.println(a);
		if (a) {
			System.out.println("ID�� ����� �� �ֽ��ϴ�.");
		} else {
			System.out.println("ID�� ����� �� �����ϴ�.");
		}
	}
}