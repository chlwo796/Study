package ch05.day03;

public class Ex163page {

	public static void main(String[] args) {
//		���ڿ� split

		String board = "��ȣ0,����0,����0,�۾���0";
		String board1 = "��ȣ1 ����1 ����1 �۾���1";
		String board2 = "��ȣ2-����2-����2-�۾���2";
		String board3 = "��ȣ3:����3:����3:�۾���3";

		String[] b1 = board.split(",");
		System.out.println(b1[0]);
		System.out.println(b1[1]);
		System.out.println(b1[2]);
		System.out.println(b1[3]);

		String[] b2 = board1.split(" "); // ���鵵 �̿� ����
		System.out.println(b2[0]);
		System.out.println(b2[1]);
		System.out.println(b2[2]);
		System.out.println(b2[3]);

		String[] b3 = board2.split("-");
		System.out.println(b3[0]);
		System.out.println(b3[1]);
		System.out.println(b3[2]);
		System.out.println(b3[3]);

		String[] b4 = board3.split(":");
		System.out.println(b4[0]);
		System.out.println(b4[1]);
		System.out.println(b4[2]);
		System.out.println(b4[3]);

//		ȫ�浿-20��, �̼���-25��, �ֿ�-30��
//		��� = �̸� ���� �̸� ���� �̸� ����

		String strA = "ȫ�浿-20��, �̼���-25��, �ֿ�-30��";
		
		String[] strArray = strA.split(", ");
		System.out.println(strArray[0]);
		System.out.println(strArray[1]);
		System.out.println(strArray[2]);
		
		String[] strArray1 = strArray[0].split("-");
		System.out.println(strArray1[0]);
		System.out.println(strArray1[1]);
		
		String[] strArray2 = strArray[1].split("-");
		System.out.println(strArray2[0]);
		System.out.println(strArray2[1]);
		
		String[] strArray3 = strArray[2].split("-");
		System.out.println(strArray3[0]);
		System.out.println(strArray3[1]);
		
//		ArrayIndexOutOfBoundsException
		
//		System.out.println(strArray3[2]);
//		System.out.println(strArray3[3]);
		
//		�迭�� ������ �ȵ��ִ� ��� error

	}

}
