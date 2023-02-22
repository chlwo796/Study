package javaChap12.example01;

public class HashCodeExample {
	public static void main(String[] args) {
		Student student1 = new Student(1, "홍길동");
		Student student2 = new Student(1, "홍길동");

		if (student1.hashCode() == student2.hashCode()) {
			if (student1.equals(student2)) {
				System.out.println("동등");
			} else {
				System.out.println("데이터가 달라서 다름");
			}
		} else {
			System.out.println("해시코드값이 달라서 다름");
		}
	}
}