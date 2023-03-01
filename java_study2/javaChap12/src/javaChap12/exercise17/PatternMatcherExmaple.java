package javaChap12.exercise17;

import java.util.regex.Pattern;

public class PatternMatcherExmaple {
	public static void main(String[] args) {
		// id ���� = ù��°�� ���ĺ�, �ι�°���� ���ڿ� ���ĺ����� ������ 8~12�� ������ ID��(��ҹ��ڱ���x)
		String id = "5Angel1004";
		String regExp = "[a-zA-Z]\\w{7,11}";
		boolean isMatch = Pattern.matches(regExp, id);
		if (isMatch) {
			System.out.println("ID�� ����� �� �ֽ��ϴ�.");
		} else {
			System.out.println("ID�� ����� �� �����ϴ�.");
		}
	}
}
