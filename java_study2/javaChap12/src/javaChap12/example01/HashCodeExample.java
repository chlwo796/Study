package javaChap12.example01;

public class HashCodeExample {
	public static void main(String[] args) {
		Student student1 = new Student(1, "ȫ�浿");
		Student student2 = new Student(1, "ȫ�浿");

		if (student1.hashCode() == student2.hashCode()) {
			if (student1.equals(student2)) {
				System.out.println("����");
			} else {
				System.out.println("�����Ͱ� �޶� �ٸ�");
			}
		} else {
			System.out.println("�ؽ��ڵ尪�� �޶� �ٸ�");
		}
	}
}