package ch05.day03;

public class Ex163page {

	public static void main(String[] args) {
//		문자열 split

		String board = "번호0,제목0,내용0,글쓴이0";
		String board1 = "번호1 제목1 내용1 글쓴이1";
		String board2 = "번호2-제목2-내용2-글쓴이2";
		String board3 = "번호3:제목3:내용3:글쓴이3";

		String[] b1 = board.split(",");
		System.out.println(b1[0]);
		System.out.println(b1[1]);
		System.out.println(b1[2]);
		System.out.println(b1[3]);

		String[] b2 = board1.split(" "); // 공백도 이용 가능
		System.out.println(b2[0]);
		System.out.println(b2[1]);
		System.out.println(b2[2]);
		System.out.println(b2[3]);

		String[] b3 = board2.split("-");
		System.out.println(b3[0]);
		System.out.println(b3[1]);
		System.out.println(b3[2]);
		System.out.println(b3[3]);

		String[] b4 = board3.split(":");
		System.out.println(b4[0]);
		System.out.println(b4[1]);
		System.out.println(b4[2]);
		System.out.println(b4[3]);

//		홍길동-20살, 이순신-25살, 최영-30살
//		출력 = 이름 나이 이름 나이 이름 나이

		String strA = "홍길동-20살, 이순신-25살, 최영-30살";
		
		String[] strArray = strA.split(", ");
		System.out.println(strArray[0]);
		System.out.println(strArray[1]);
		System.out.println(strArray[2]);
		
		String[] strArray1 = strArray[0].split("-");
		System.out.println(strArray1[0]);
		System.out.println(strArray1[1]);
		
		String[] strArray2 = strArray[1].split("-");
		System.out.println(strArray2[0]);
		System.out.println(strArray2[1]);
		
		String[] strArray3 = strArray[2].split("-");
		System.out.println(strArray3[0]);
		System.out.println(strArray3[1]);
		
//		ArrayIndexOutOfBoundsException
		
//		System.out.println(strArray3[2]);
//		System.out.println(strArray3[3]);
		
//		배열이 범위가 안되있는 경우 error

	}

}
