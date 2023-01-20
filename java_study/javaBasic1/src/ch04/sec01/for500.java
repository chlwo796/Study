package ch04.sec01;

public class for500 {

	public static void main(String[] args) {
//		100~1 출력중 합이 500, 1000, 1500, 2000 ...5000일때 i값
//		알고리즘 짜기
//		합 누적 변수가 500이 넘을 때, 그순간의 i값 출력 한번만
//		다시 for, 그러면 500 단위로 그때의 i 값을 출력한다면?
		
		int sum = 0;
		int i = 100;
		int value = 500;

		for (; i >= 1; i--) {
			sum = sum + i;
			for (; sum > value; value += 500) {
				System.out.println(i);
			}

		}

	}

}
