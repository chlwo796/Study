package ch05.sec05;

public class SplitExample {

	public static void main(String[] args) {
//		���ڿ� �и� [] = .split()
//		���ڿ��� �� ��� �迭Ÿ������ .split() method�� �������ָ� ���� �и��� ���ڿ��� ���� �� �ִ�.
		
		String strA = "5, �ڹ� �н�, ���� Ÿ�� String�� �����ϰ� �ֽ��ϴ�., ����ȯ";
		
		System.out.println(strA);
		
		String[] splitA = strA.split(",");
		
//		System.out.println(splitA[1]);	// �迭�� ����� ���� ��, [index] �������� �������� �Է��Ѵ�. [1]=splitA�� 2��° index ���
		
		System.out.println("��ȣ = " + splitA[0]);
		System.out.println("���� = " + splitA[1]);
		System.out.println("���� = " + splitA[2]);
		System.out.println("�̸� = " + splitA[3]);
		
//		�ݺ������� ����� �����ϴ�.
		
		for(int i= 0; i<=3; i++) {
			System.out.println(splitA[i]);
		}
		

	}

}
