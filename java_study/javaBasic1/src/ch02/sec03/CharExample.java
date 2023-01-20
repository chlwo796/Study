package ch02.sec03;

import java.util.Scanner;

public class CharExample {

	public static void main(String[] args) {
		//���� �ѱ��� 'a' ��ǻ�� ����ϴ� �� ���蹮�ڴ� �����ڵ�� ����ص�
		char aWord = 'a'; //a�� �����ڵ� = 97
		System.out.println((char)(aWord - 32)); //(char) = data type char�� ����
		
		char bWord = 'K';
		System.out.println( (char) (bWord + 40)); //���� K�� s�� ����ϱ�
		
		char name1 = '��';
		char name2 = '��';
		char name3 = 'ȯ'; //��ǻ�Ϳ��� ó���Ǵ� ���ڴ� �����ڵ�� ó���ȴ�.
		
		System.out.println((int) (name1) + " " + (int) name2 + " " + (int) (name3));
		
		//�������� ���ڿ� " " ���ڿ� ��ü String�� ����Ѵ�
		String name = "����ȯ"; //�ѱ� 1���� = 3byte 2���� = 6byte ...
		
		String hakbun = "221208"; 
		
		int hakbun1 = 221208;   //���ڿ��� ���������� �ٲ۴�.
		//���� �й��� ��������� �й��� ���Ͻÿ� �� = 221209
		
		System.out.println("���� ����� �й��� " + (hakbun1 + 1));
		
		System.out.println(Integer.MAX_VALUE); //������ �ִ밪.
		System.out.println(Integer.BYTES);//������ 4byte�̴�.
		System.out.println(Integer.SIZE); // 1byte = 8bit
		System.out.println(Integer.valueOf(hakbun)+1);
		
		String avgS = "52.2"; // 52.2 + 100 = 152.2
		// ���ڿ��� ����� �ȵǴ� ���ڿ��� �Ǽ������� �ٲ�� �Ѵ�.
		// 100�� ���� ����Ѵ�. double�� �Ǽ���
		System.out.println(Double.valueOf(avgS)+100);
		float convAvg = Float.parseFloat(avgS); //"52.2" --> 52.2
		convAvg = convAvg + 100;
		System.out.println(convAvg);
		
		String sex = "false"; //"true" --> true
		//���ڿ� "true"�� �Ҹ���(��)�� ��ȯ�ϼ���
		boolean conSex = Boolean.parseBoolean(sex);
		//boolean conSex = Boolean.valueOf(sex);
		//parse = �ٲ��.
		System.out.println(conSex);
		if (conSex)
			System.out.println("����"); //true�� ����
		else
			System.out.println("����"); //false�� ����
		
		//�ڵ�Ÿ�Ժ�ȯ
		byte v1 = 10; //1byte
		int v2 = 20; //4byte
		
		v2 = v1; // v1�� v2�ڸ��� ����. v2 = 10 byte���� ���� int������ ����. ū ������ �̵��ϴ� ���� ����.
		
		//������ ��ȯ
		v1 =(byte) v2; //v2�� ���� v1�� �ִ´�. �� int���� byte������ ����. ū ���� ���� ������ ��.
		
		int v3 = 50;
		double v4 = 10.0; //8byte �Ҽ������� 32�ڸ����� ǥ��
		float v5 = 20.5f; //4byte, �Ҽ������� 8�ڸ����� ǥ��, float type���� ���� �ڿ� f�� ������.
		
		v4 = v3;  //�Ǽ����� ������ ���� ū ����.
		v4 = v5;
		v3 = (int) v4;
		v3 = (int) v5;
		v5 = (float) v4;
		
		//�� ��ȯ �ſ� �߿�!!
		
		//���� ����2���� �Է¹޾Ƽ� ��Ģ���� �غ�����
		Scanner sc = new Scanner(System.in); //Ű���� �Է��� ����ϴ� Scanner Ŭ������ ����Ѵ�.
		
		/*int x = sc.nextInt(); //Ű���忡�� ������ �Է¹޴´�.
		System.out.println("�Է°�" + x);
		
		int y = sc.nextInt();
		System.out.println("�Է°�" + y);*/
		
		//double������ �Ǽ� 2���� �Է¹�������
		
		/*double c = sc.nextDouble();
		double d = sc.nextDouble();
		System.out.println("�Ǽ��Է°�" + c);
		System.out.println("�Ǽ��Է°�" + d);*/
		
		/*boolean x = sc.nextBoolean();
		boolean y = sc.nextBoolean();*/
		
		String c = sc.nextLine(); //�����ִ� ��°��� ���ϸ� nextLine
		System.out.println(c);
		String d = sc.next(); //�������
		System.out.println(d);
	}

}
