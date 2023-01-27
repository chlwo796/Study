package javaMId2.ex03;

import javaMId2.ex02.A;

public class AB extends A{
	void m() {
		value = 2000;	// 다른 패키지일지라도, 부모의 자료를 사용 할 수 있다. protectd
	}
}
