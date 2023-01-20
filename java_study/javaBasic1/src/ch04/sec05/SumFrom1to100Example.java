package ch04.sec05;

public class SumFrom1to100Example {

	public static void main(String[] args) {
//		1부터 100까지의 합, while
		
		int i = 1;
		int sum = 0;
		
		while(i<=100) {
			sum = sum + i;
			i++;
		}
		System.out.println("1부터 " + (i-1) + "까지의 합은 " + sum + "입니다.");

	}

}
