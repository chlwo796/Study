package ch04.sec01;

public class ContinueEx3 {

	public static void main(String[] args) {
//		 1~50���� 10,20,30..50 ���� ���

//		for (int i = 1; i <= 50; i++) {
//			if (i % 10 == 0)
//				continue;
//			// if()�� true�� continue�� �Ʒ� �������� ���� �ʰ�, �ݺ��� �ٽ� ����
//			// i�� 10�� �� �������� 0, true, for again
//			System.out.print(i + " ");
//		}

//		100~1���� ���, �հ谡 500�� ������ �׸� ���, 1000�� ������ �׸� ���, 1500..2000
//		�հ谡 500���� �������� 1�� �Ѵ� ����. 500���� �������� 2�� �Ѵ� ����.

		System.out.println();

		int i = 100;
		int sumA = 0;
		boolean x = false;	// 500�� �Ѵ� ���� 1���� ����ؾ���
		int basu = 500;	// �ʱⰪ
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
//		System.out.println("�հ�:"+sum+" "+"�׸�:"+i);
//		sum = 0;
//		}

		
//		Ȯ�ι���4
//		������ ���ϴ� �Լ� 0.0 <= Math.random() <1.0
		System.out.println((int) (Math.random()*10));	// 10�� ���ؼ� ����ȭ�Ѵ�. 0~9
//		���л���
//		0<= x <9 , 0*6<= x < 9*6, 0<= x <5, 0+1 <= x < 5+1
		System.out.println((int) ((Math.random()*6) + 1));	// �ڵ�ȭ
		
		System.out.println((int) ((Math.random()*2) + 1));	// 1,2 ��, �� ����
		
		System.out.println((int) ((Math.random()*14) + 1)); // 1~14
		
		System.out.println((int) ((Math.random()*49) + 1));	// 1~49  0~0.99999 -> 0~48.99999 -> 1 ~ 49
		
}
}

