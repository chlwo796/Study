package ch04.jhc;

public class Example3 {

	public static void main(String[] args) {
//		for �̿��ؼ� 1���� 100������ ���� �߿��� 3�� ����� ������ ���

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
