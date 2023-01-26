package javaMid1.ch07;

public class ExtendsEx01 {

	public static void main(String[] args) {
//		상속
//		A extends P
		A a = new A(); // 자식클래스가 객체화되면 부모클래스의 데이터도 사용할 수 있다.

		a.setName("최재환");
		a.setPhone("01041160586");

		System.out.println(a.getName());
		System.out.println(a.getPhone());
//		System.out.println(a.printM()); a.printM()은 return타입이 없어 data input을 할 수 없다.
		a.printM(); // method 자체를 호출해준다.

//		B extends P
		B b = new B();
		b.setAge(30);
		b.setPhone("0104238238");

		System.out.println(b.getAge());
		System.out.println(b.getPhone());

//		C field school 서울대학교, 이름, 번호 나이 전부 출력
//		C->B->A->P 상속관계 = C클래스에서는 B,A,P 데이터 모두 사용 가능
		C c = new C();
		
		c.setSchool("서울대학교");
		c.setAge(30);
		c.setName("최재환");
		c.setPhone("01041150505");

		c.printAll();
	}
}