package javaMid4.ex03;

public class InConfigImpl implements InConfig {
//	classNameImpl = 구현클래스임을 명시적으로 알 수 있다.

	@Override
	public void i1() {
		// TODO Auto-generated method stub

	}

	@Override
	public void di1() {
//		default method는 {} 포함이기때문에 overriding 하지 않아도 된다.
		InConfig.super.di1();
	}

}
