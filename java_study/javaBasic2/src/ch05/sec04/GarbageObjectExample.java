package ch05.sec04;

public class GarbageObjectExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String hobby = "���";
		System.out.println(hobby);
		hobby = "����";
		System.out.println(hobby);
		hobby = null;
		System.out.println(hobby);
		
		String car1 = "�ڵ���";
		String car2 = car1;	// 2�� 1�� ����.
		System.out.println(car1 + " " +car2);	//2�� 1�� ���������� ��°�
		
		car1 = null;	// car1�� null���� ����
		
		System.out.println(car1 + " " +car2);	// �Ѵ� �ٲ��� �ʴ´�.

	}

}
