package javaChap12.example10;

public class Service {
	@PrintAnnotation	// default �Ӽ���� ����
	public void method1() {
		System.out.println("���೻��1");
	}

	@PrintAnnotation("*")	// value�� ���� ���� = value ��������
	public void method2() {
		System.out.println("���೻��2");
	}

	@PrintAnnotation(value = "#", number = 20)	// number �Ӽ��� ���� = value �����Ұ�
	public void method3() {
		System.out.println("���೻��3");
	}
}
