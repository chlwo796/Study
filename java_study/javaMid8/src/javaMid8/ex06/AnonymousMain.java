package javaMid8.ex06;

// Ȯ�ι��� 9.6

public class AnonymousMain {
	public static void main(String[] args) {
		Anonymous anonymous = new Anonymous();
		anonymous.field.run();
		anonymous.method1();
		anonymous.method2(new Vehicle() {
//			�޼ҵ忡�� �ٷ� �͸�����ü�� ���� ȣ���ϱ�. �ſ��߿�.
			@Override
			public void run() {
				System.out.println("Ʈ���� �޸��ϴ�.");
			}
		});
	}
}