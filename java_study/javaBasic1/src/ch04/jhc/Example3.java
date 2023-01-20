package ch04.jhc;

public class Example3 {

	public static void main(String[] args) {
//		for 이용해서 1부터 100까지의 정수 중에서 3의 배수의 총합을 출력

		int i = 1;
		int sum = 0;
		
		for(;i<=100;i++) {
			int rem = i%3;
			if (rem == 0){
				sum = sum + i;
			} 
		}System.out.println(sum);
	}

}
