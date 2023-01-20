package ch05.day03;

public class NullEx01 {

	public static void main(String[] args) {
//		Null, NullPointerException
//		�������� = heap memory�� �ּҸ� ������ �ִ� ����
//		null = heap memory�� �ּҸ� ���� �־����� �ʾҴ�. ���߿� ���� ���̴�. �ʱⰪ ����
		
		Ezen st = null;	// st �������� �������� ��� ���� �ʴ�. stack memory���� �ڸ� ����.
		System.out.println(st);
		Ezen ez1 = new Ezen();
		ez1.setName("����ȯ");	// "ȫ�浿" -> String Ÿ�� name ����
		System.out.println("�̸� : " + ez1.getName());
		ez1.setPhone("010-4116-0586");
		System.out.println("��ȣ : " + ez1.getPhone());
		ez1.setKor(100);
		System.out.println("���� : " + ez1.getKor());
	}

}
//		method�� ���ؼ� ���� ���� ����, ��ü������ ū Ʋ
class Ezen{
	String name;
	String phone;
	int kor;
	
	void setName(String name) {	// "ȫ�浿"->String name
		this.name = name;	// name -> this.name(class�Ҽ�field)
	}
	void setPhone(String phone) {
		this.phone = phone;
	}
	void setKor(int kor) {
		this.kor = kor;
	}
	String getName(){
		return this.name;	// this.���� name���ε� ����. ���� ����� ������ class�Ҽ� field
	}
	String getPhone() {
		return this.phone;
	}
	int getKor() {
		return this.kor;
	}
}
