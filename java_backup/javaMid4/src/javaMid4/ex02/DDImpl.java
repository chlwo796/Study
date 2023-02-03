package javaMid4.ex02;

public class DDImpl implements CC, D {
	@Override
	public boolean d1() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void cc1() {
		// TODO Auto-generated method stub

	}
	
//	interface CC는 interface C를 부모로 하기때문에 
//	CC를 구현하는 DDImpl은 위 interface의 메소드를 모두 overriding해야한다.
	@Override
	public int c1() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int c2() {
		// TODO Auto-generated method stub
		return 0;
	}
}
