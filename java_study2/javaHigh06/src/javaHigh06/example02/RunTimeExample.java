package javaHigh06.example02;

public class RunTimeExample {
	public static void main(String[] args) {
//		long startMiTime = System.nanoTime();
		long startMiTime = System.currentTimeMillis();
		System.out.println(startMiTime);
		
		long sum = 0;
		for(long i = 1;i<=1000000000L;i++) {
			sum+=i;
		}
//		long endTime = System.nanoTime();
		long endMiTime = System.currentTimeMillis();
		System.out.println(((endMiTime-startMiTime) / 100) + "s");
		
		
	}
}
