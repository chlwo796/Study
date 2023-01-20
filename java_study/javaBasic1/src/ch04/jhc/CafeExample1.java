package ch04.jhc;

public class CafeExample1 {

	public static void main(String[] args) {
//		 1에서 100까지 정수 중에서 2,3,5,7의 배수를 제외한 수를 한 행에 10개씩 출력
		int cnt = 0;
		for( int i =1; i<=100; i++) {
				if(i%2 != 0 && i%3 != 0 && i%5 != 0 && i%7!=0) {
					System.out.print(i + " ");
					cnt++;
			}	if(cnt == 10) {
				System.out.println();
				cnt = 0;
			}
		}

}

}
