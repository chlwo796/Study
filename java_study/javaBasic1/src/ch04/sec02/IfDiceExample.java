package ch04.sec02;

public class IfDiceExample {

	public static void main(String[] args) {
		// �ֻ������� ���� ���ڸ� ����ϴ� ���α׷�
		int a = (int) ((Math.random()*6)+1);
		
		if(a == 1) {
			System.out.println("1���� ���Խ��ϴ�");
		}
		else if(a == 2) {
			System.out.println("2���� ���Խ��ϴ�");
		}
		else if(a == 3) {
			System.out.println("3���� ���Խ��ϴ�");
		}
		else if(a == 4) {
			System.out.println("4���� ���Խ��ϴ�");
		}
		else if(a == 5) {
			System.out.println("5���� ���Խ��ϴ�");
		}else {
			System.out.println("6���� ���Խ��ϴ�");
		}
	}

}
