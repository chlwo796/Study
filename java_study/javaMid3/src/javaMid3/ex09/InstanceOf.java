package javaMid3.ex09;

public class InstanceOf {
	public static void personInfo(Person person) {
		System.out.println("name : " + person.name);
		person.walk();
//		System.out.println(person.studentNo); 
//		�θ� �޸𸮿� �ö��ֱ� ������ studentNo�� �ҷ��� �� ����.
//		�ٿ�ĳ����(Student)person : ��������ȯ ���� ���
//		Ȥ�� �������̵����� ���� ����
//		Animal animal = new Cat();
//		(Cat) animal

		Student s = (Student) person;
		System.out.println(s.studentNo);

		if (person instanceof Student) {
//			System.out.println("studentNo: " + student.studentNo);
//			student.study();	// ���� = java 12���� ����
//			person��ü�� �ּҰ� Student class�� ����ų �� ������ true
//			main�� ��ü���� ����� ���� �ٸ� ������ ������ �� �� �ִ�.
			System.out.println("studentNo: " + s.studentNo);
			s.study();
		}
	}

	public static void main(String[] args) {
		Person p1 = new Person("ȫ�浿");
		personInfo(p1);

		System.out.println();

		Person p2 = new Student("��浿", 10);
		personInfo(p2);
	}
}
