package ch04.jhc;

public class CafeExample1 {

	public static void main(String[] args) {
//		 1���� 100���� ���� �߿��� 2,3,5,7�� ����� ������ ���� �� �࿡ 10���� ���
		int cnt = 0;
		for( int i =1; i<=100; i++) {
				if(i%2 != 0 && i%3 != 0 && i%5 != 0 && i%7!=0) {
					System.out.print(i + " ");
					cnt++;
			}	if(cnt == 10) {
				System.out.println();
				cnt = 0;
			}
		}

}

}
