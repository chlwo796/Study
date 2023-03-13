package tempMemo;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String str = sc.next();
//		int number = sc.nextInt();
//
//		School school1 = new School("Jejuelementary", 6);
//		School school2 = new School(str, number);
//		System.out.println(school1);
//		System.out.println(school2);

//		sc.close();
		School school = new School("남한고등학교");
		System.out.println(school);

		school = new School("경기고등학교", "경기");
		System.out.println(school);
		
		school = new School("미사고등학교", "강원", "최재환");
		System.out.println(school);
		
		
	}
}