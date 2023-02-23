package javaHigh06.example08;

import java.util.regex.Pattern;

public class PatternEx {
	public static void main(String[] args) {
		// -[1-4] = 1~4�� ���ڸ�
		String regExp1 = "\\d{6}-[1-4]\\d{6}";
		if (Pattern.matches(regExp1, "930122-1209218")) {
			System.out.println("��ġ�մϴ�.");
		}else {
			System.out.println("�߸��� �ֹε�Ϲ�ȣ�Դϴ�.");
		}
		String regExp2 = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		if (Pattern.matches(regExp2, "chlwo796@gmail.com")) {
			System.out.println("��ġ�մϴ�.");
		}else {
			System.out.println("�߸��� �̸����Դϴ�.");
		}
	}
}