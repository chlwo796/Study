package tempMemo1;

public class A {
	public A() {
//		A�� �⺻������
	}

	B b = new B() {
//		public B() {
//			super();
//			�͸��ڽİ�ü�̹Ƿ� �θ�Ÿ���� �����ڸ� ������ �� �ִ�. �����Ұ�
//			�޼ҵ常 ���� �����ϴ�.
//		}

		@Override
		void methodB() {
			System.out.println("BŬ������ �͸��ڽİ�ü");
		}
	};
}
