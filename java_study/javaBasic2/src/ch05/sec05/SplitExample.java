package ch05.sec05;

public class SplitExample {

	public static void main(String[] args) {
//		문자열 분리 [] = .split()
//		문자열이 긴 경우 배열타입으로 .split() method를 실행해주면 각각 분리된 문자열을 얻을 수 있다.
		
		String strA = "5, 자바 학습, 참조 타입 String을 공부하고 있습니다., 최재환";
		
		System.out.println(strA);
		
		String[] splitA = strA.split(",");
		
//		System.out.println(splitA[1]);	// 배열의 출력을 원할 때, [index] 형식으로 변수옆에 입력한다. [1]=splitA의 2번째 index 출력
		
		System.out.println("번호 = " + splitA[0]);
		System.out.println("제목 = " + splitA[1]);
		System.out.println("내용 = " + splitA[2]);
		System.out.println("이름 = " + splitA[3]);
		
//		반복문으로 출력이 가능하다.
		
		for(int i= 0; i<=3; i++) {
			System.out.println(splitA[i]);
		}
		

	}

}
