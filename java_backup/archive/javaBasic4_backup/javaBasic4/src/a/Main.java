package a;

import a.aa.AA;
import b.B;	// b라는 패키지의 B클래스를 사용하겠다. has a 관계
import b.ba.BA;

public class Main {

	public static void main(String[] args) {
		// B클래스의 정적 변수값 출력하기
		System.out.println(B.getSb());	// field바로 호출x, method 호출
		AA aa = new AA();
//		AA aa = new a.aa.AA();
		System.out.println(aa.getName() + " " + aa.getPhone());
		
		BA ba = new BA();
		
		System.out.println(ba.getId() + " " + BA.getSd());
	}
}
