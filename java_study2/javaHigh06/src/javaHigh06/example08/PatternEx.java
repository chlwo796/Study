package javaHigh06.example08;

import java.util.regex.Pattern;

public class PatternEx {
	public static void main(String[] args) {
		// -[1-4] = 1~4의 숫자만
		String regExp1 = "\\d{6}-[1-4]\\d{6}";
		if (Pattern.matches(regExp1, "930122-1209218")) {
			System.out.println("일치합니다.");
		}else {
			System.out.println("잘못된 주민등록번호입니다.");
		}
		String regExp2 = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		if (Pattern.matches(regExp2, "chlwo796@gmail.com")) {
			System.out.println("일치합니다.");
		}else {
			System.out.println("잘못된 이메일입니다.");
		}
	}
}