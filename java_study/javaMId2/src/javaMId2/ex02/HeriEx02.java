package javaMId2.ex02;

import javaMId2.ex03.AB;
import javaMId2.ex03.C;

public class HeriEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		a.value = 200;	// protected value 호출 가능여부 확인
		System.out.println(a.value);
		
		AA aa = new AA();
		System.out.println(aa.value);
		
		AB ab = new AB();	// 다른패키지에 있는 클래스. import
		System.out.println(ab.value);
		
		C c = new C();
//		System.out.println(c.value); // 상속관계가 아니기 때문에 변수 사용 불가.
		
	}

}
