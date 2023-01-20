package ch02.sec06;

public class StringExample {

	public static void main(String[] args) {
		// String type
		String name = "최재환";
		String job = "백수";
		
		System.out.println(name);
		System.out.println(job);
		
		String java = "나는 \"자바\"를 배웁니다.";	// \바로 옆 문자를 문자로취급한다.
		System.out.println(java);
		
		String nameTab = "최\t재\t환";
		System.out.println(nameTab);	// \t = 출력시 Tab만큼 띄움.
		
		String nameLine = "최\n재\n환";	// \n = 출력시 줄바꿈
		System.out.println(nameLine);

	}

}
