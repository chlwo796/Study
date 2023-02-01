package javaMid3.ex09;

public class InstanceOf {
	public static void personInfo(Person person) {
		System.out.println("name : " + person.name);
		person.walk();
//		System.out.println(person.studentNo); 
//		부모만 메모리에 올라가있기 때문에 studentNo를 불러올 수 없다.
//		다운캐스팅(Student)person : 강제형변환 같은 방식
//		혹은 오버라이딩으로 접근 가능
//		Animal animal = new Cat();
//		(Cat) animal

		Student s = (Student) person;
		System.out.println(s.studentNo);

		if (person instanceof Student) {
//			System.out.println("studentNo: " + student.studentNo);
//			student.study();	// 오류 = java 12부터 가능
//			person객체의 주소가 Student class를 가르킬 수 있으면 true
//			main의 객체생성 방법에 따라 다른 로직을 실행해 볼 수 있다.
			System.out.println("studentNo: " + s.studentNo);
			s.study();
		}
	}

	public static void main(String[] args) {
		Person p1 = new Person("홍길동");
		personInfo(p1);

		System.out.println();

		Person p2 = new Student("김길동", 10);
		personInfo(p2);
	}
}
