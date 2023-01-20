package ch04.sec07;

public class ContinueExample {

	public static void main(String[] args) {
//		숫자 반복출력 중 짝수만 출력하기

		for (int i = 1; i <= 100; i++) {
			if (i % 2 != 0) {
				continue;
			}
			System.out.println(i);
		}
//		continue; 실행과 동시에 해당 중괄호 탈출 후 만나는 실행문 실행x, 다시 반복문 수행
//		따라서 홀수(i%2!=0)조건이 참이면 continue;한다.
//		continue -> i 출력x -> for i++
//		짝수 출력시 continue를 사용하고싶으면 홀수 조건에 continue;하면 짝수만 뽑기 가능하다.
//		break;= 다시 반복문x, continue; = 다시 반복문o
	}
}