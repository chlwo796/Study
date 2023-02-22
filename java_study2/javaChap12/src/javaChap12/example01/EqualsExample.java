package javaChap12.example01;

public class EqualsExample {
	public static void main(String[] args) {
		Member member1 = new Member("1");
		Member member2 = new Member("1");
		Member member3 = new Member("3");

		if (member1.equals(member2)) {
			System.out.println("1과 2는 동등");
		} else {
			System.out.println("1과 2는 다름");
		}
		if (member1.equals(member3)) {
			System.out.println("1과 3은 동등");
		} else {
			System.out.println("1과 3은 다름");
		}
	}
}