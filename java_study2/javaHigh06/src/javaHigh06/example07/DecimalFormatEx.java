package javaHigh06.example07;

import java.text.DecimalFormat;

public class DecimalFormatEx {
	public static void main(String[] args) {
		// �Ҽ��� 16°�ڸ� ������ ���(�ݿø�)
		double d1 = 0.1234567891234565678989213;
		System.out.println(d1);
		double d2 = 10;
		// �Ҽ��� 3�ڸ�
		// # �ڸ��� ���ڰ� ������ ������ ����
		DecimalFormat df1 = new DecimalFormat("#.###");
		System.out.println(df1.format(d1));
		
		System.out.println(df1.format(d2));
		DecimalFormat df2 = new DecimalFormat("0.00");
		System.out.println(df2.format(d1));
		// �ѹ� �� ����, ��ȭ��ȣ
		DecimalFormat df3 = new DecimalFormat("\u00A4#,###");
		System.out.println(df3.format(1234567.89));
	}
}
