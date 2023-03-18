package chap07;

public class ImpeCalculator implements Calculator {
	public ImpeCalculator() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public long factorial(long num) {
//		long start = System.currentTimeMillis();
		long result = 1;
		for (long i = 1; i <= num; i++) {
			result *= i;
		}
//		long end = System.currentTimeMillis();
		// 이 시간측정기능은 프록시가 구현하도록 한다. 핵심기능 = 계산
//		System.out.printf("ImpeCalculator.factorial(%d) 실행 시간 = %d\n", num, (end - start));
		return result;
	}
}