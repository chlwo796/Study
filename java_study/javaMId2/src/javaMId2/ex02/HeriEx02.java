package javaMId2.ex02;

import javaMId2.ex03.AB;
import javaMId2.ex03.C;

public class HeriEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		a.value = 200;	// protected value ȣ�� ���ɿ��� Ȯ��
		System.out.println(a.value);
		
		AA aa = new AA();
		System.out.println(aa.value);
		
		AB ab = new AB();	// �ٸ���Ű���� �ִ� Ŭ����. import
		System.out.println(ab.value);
		
		C c = new C();
//		System.out.println(c.value); // ��Ӱ��谡 �ƴϱ� ������ ���� ��� �Ұ�.
		
	}

}
