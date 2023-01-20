package ch04.sec01;

public class ContinueEx3 {

	public static void main(String[] args) {
//		 1~50까지 10,20,30..50 빼고 출력

//		for (int i = 1; i <= 50; i++) {
//			if (i % 10 == 0)
//				continue;
//			// if()가 true면 continue의 아래 문장으로 가지 않고, 반복문 다시 실행
//			// i가 10일 때 나머지가 0, true, for again
//			System.out.print(i + " ");
//		}

//		100~1까지 출력, 합계가 500인 순간의 항목 출력, 1000인 순간의 항목 출력, 1500..2000
//		합계가 500으로 나눴을때 1이 넘는 순간. 500으로 나눴을때 2가 넘는 순간.

		System.out.println();

		int i = 100;
		int sumA = 0;
		boolean x = false;	// 500이 넘는 순간 1번만 출력해야함
		int basu = 500;	// 초기값
		for (; i >= 1; i--) {
			sumA = sumA + i;
			if(basu % 500 == 0) {
				x = false;
			}
			if (sumA >= basu && !x) {
			System.out.println(i);
			x = true;
			basu = basu + 500;
			
		}
	}
		
//		int sum = 0;
//		int i=0;
//		int number =0;
//		for (number=500;number<=5000;number+=500) {
//			for(i=100;i>=1;i--) {
//				sum = sum + i;
//				if(sum>number) break;
//			}
//		System.out.println("합계:"+sum+" "+"항목:"+i);
//		sum = 0;
//		}

		
//		확인문제4
//		난수를 구하는 함수 0.0 <= Math.random() <1.0
		System.out.println((int) (Math.random()*10));	// 10을 곱해서 정수화한다. 0~9
//		수학생각
//		0<= x <9 , 0*6<= x < 9*6, 0<= x <5, 0+1 <= x < 5+1
		System.out.println((int) ((Math.random()*6) + 1));	// 코드화
		
		System.out.println((int) ((Math.random()*2) + 1));	// 1,2 앞, 뒤 개념
		
		System.out.println((int) ((Math.random()*14) + 1)); // 1~14
		
		System.out.println((int) ((Math.random()*49) + 1));	// 1~49  0~0.99999 -> 0~48.99999 -> 1 ~ 49
		
}
}

