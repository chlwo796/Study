package a;

import a.aa.AA;
import b.B;	// b��� ��Ű���� BŬ������ ����ϰڴ�. has a ����
import b.ba.BA;

public class Main {

	public static void main(String[] args) {
		// BŬ������ ���� ������ ����ϱ�
		System.out.println(B.getSb());	// field�ٷ� ȣ��x, method ȣ��
		AA aa = new AA();
//		AA aa = new a.aa.AA();
		System.out.println(aa.getName() + " " + aa.getPhone());
		
		BA ba = new BA();
		
		System.out.println(ba.getId() + " " + BA.getSd());
	}
}
