package ch05.day02;

public class ClassEx153Page {

	public static void main(String[] args) {
//		교재 153페이지
		
		String name = "홍길동이순신최재환";
		String name1 = "홍길동";
		
		String name2 = new String("홍길동");
		String name3 = new String("홍길동");
		
		char c0 = name.charAt(6);
		System.out.println(c0);
		
		int length = name.length();
		System.out.println("길이는 " + length);
		
		String changeword = name.replace("최재환", "각자이름");
		System.out.println(changeword);
		
		String subString = name.substring(1, 8);
		System.out.println(subString);
		
		int index = name.indexOf("아");
		System.out.println(index);		
//		없으면 -1 출력, 조건식으로 문자열 찾기 가능.
		
		boolean result = name.contains("길동");
		System.out.println(result);
		
	}

}
