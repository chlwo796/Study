package javaChap12.example02;

public class MesureRunTimeExample {
	public static void main(String[] args) {
		long time1 = System.nanoTime();
		int sum = 0;
		for(int i = 0;i<100000000;i++) {
			sum+=i;
		}
		long time2 = System.nanoTime();
		
		System.out.println("���� : " + sum);
		System.out.println((time2 - time1) + "������ �ҿ�Ǿ����ϴ�.");
	}
}
