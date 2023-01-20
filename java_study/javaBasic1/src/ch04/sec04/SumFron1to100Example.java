package ch04.sec04;

public class SumFron1to100Example {

	public static void main(String[] args) {
//		1부터 100까지의 합, for활용
		int sum = 0;
		int i;
		for (i = 1; i <= 100; i++) {
			sum = sum + i;
		}
		System.out.println("1부터 " + (i-1) + "까지의 합 = " + sum);
//		sum이라는 변수를 초기값을 0으로 선언해주고, for의 변수 i가 1부터 100까지 반복실행될 때마다,
//		sum이라는 변수에 i값을 계속 더해준다(누적합계)
//		sum이라는 변수를 for {}안에서 선언해주면 for 밖에서 한번만 출력을 원할 때는 출력이 되지가 않는다.
//		출력에 (i-1)인 이유 = i값은 마지막으로(i = 100) sum을 계산해주고 i++을 한 후 (i = 101)로 for문이 종료된다. 
	}

}
