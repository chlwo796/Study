package ch04.sec07;

public class BreakExample {

	public static void main(String[] args) {
//		while �̿�, �ֻ��� ��ȣ�� �ݺ����, 6�� ������ ����.
		
		System.out.println("�ֻ��� ���α׷�");
		while(true) {
			int number = (int)((Math.random()*6)+1);
			System.out.println(number + "�� ���Խ��ϴ�.");
			if(number == 6) {
				System.out.print("�����ϰڽ��ϴ�.");
				break;
			}
		}
	}

}
