package javaMid5.ex06;

public class Parent {
//	예제6번
//	public String name;
//
//	public Parent(String name) {
//		this.name = name;
////		이 생성자가 있기 때문에 기본생성자가 생기지 않는다.
//	}
//
//	public Parent() {
////		부모의 기본생성자를 만들어 놓아도 에러 수정 가능
//	}

//	예제7번
	public String nation;

	public Parent() {
		this("대한민국");
		System.out.println("Parent() call");

	}

	public Parent(String nation) {
		this.nation = nation;
		System.out.println("Parent(String nation) call");
	}
}
