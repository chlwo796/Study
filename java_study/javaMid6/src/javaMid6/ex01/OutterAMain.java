package javaMid6.ex01;

public class OutterAMain {
	public static void main(String[] args) {
		OutterA outterA = new OutterA();

		OutterA.InnerA innerA = outterA.new InnerA();

		innerA.methodInnerA(); // OutterA, InnerA�� ���� a�� �帧�� �ٽú���.

//		inner class�� outter�� member�� ��� ����� �� �ְ�, outter���� inner�� ���ѵȴ�.
//		Ŭ���� ��ø�� ���� �ܺο��� �������� ���ϵ��� �ؾ��ϴ� class�� inner�� �����ؼ� ����Ѵ�.

	}
}