package ch05.sec05;

public class SubStringExample {

	public static void main(String[] args) {
//		�߶󳻱� = .substring();
//		.substring(int beginindex) = beginindex���� ������ �߶󳻱�
//		.substring(int beginindex, int endindex) = beginindex���� endindex �ձ��� �߶󳻱�
		
		String number = "930122-1209218";
		String firstNumber = number.substring(0,6);	// 0���� 6 �ձ���,0~5 6�ڸ�
		String secondNumber = number.substring(7);	// 7�ڸ����� ������
		
		System.out.println(firstNumber);
		System.out.println(secondNumber);
		
	}

}
