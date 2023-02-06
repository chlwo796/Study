package javaMid7.ex07;

public class Home {
	private RemoteControl rc = new RemoteControl() {
//		인터페이스 RemoteControl 자체를 객체생성한 것이 아니라
//		인터페이스 RemoteControl의 익명형 구현 클래스를 객체생성한 것이므로 가능하다.

		@Override
		public void turnOn() {
			// TODO Auto-generated method stub

		}

		@Override
		public void turnOff() {
			// TODO Auto-generated method stub

		}
	};
	private A a = new A() {

		@Override
		public void abM2() {
			// TODO Auto-generated method stub

		}

		@Override
		public void abM1() {
			// TODO Auto-generated method stub

		}
	};
}