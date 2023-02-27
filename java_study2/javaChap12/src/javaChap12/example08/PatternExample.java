package javaChap12.example08;

import java.util.regex.Pattern;

public class PatternExample {
	public static void main(String[] args) {
		String regExp = "(02|010)-\\d{3,4}-\\d{4}";
		String data = "010-4116-0586";
		boolean result = Pattern.matches(regExp, data);
		if(result) {
			System.out.println("��ġ");
		}else {
			System.out.println("����ġ");
		}
		regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
		data = "chlwo796@naver.com";
		result = Pattern.matches(regExp, data);
		if(result) {
			System.out.println("�̸�����ġ");
		}else {
			System.out.println("����ġ");
		}
	}
}
