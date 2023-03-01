package javaChap12.exercise17;

import java.util.regex.Pattern;

public class PatternMatcherExmaple {
	public static void main(String[] args) {
		// id 조건 = 첫번째는 알파벳, 두번째부터 숫자와 알파벳으로 구성된 8~12자 사이의 ID값(대소문자구분x)
		String id = "5Angel1004";
		String regExp = "[a-zA-Z]\\w{7,11}";
		boolean isMatch = Pattern.matches(regExp, id);
		if (isMatch) {
			System.out.println("ID로 사용할 수 있습니다.");
		} else {
			System.out.println("ID로 사용할 수 없습니다.");
		}
	}
}
