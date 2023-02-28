package javaHigh07.example01;

public class GenericEx07 {
	public static void main(String[] args) {
		// Applicant<?> applicant = 타입 전부 참조 가능
		Course.registerCourse1(new Applicant<Person>(new Person()));
		Course.registerCourse1(new Applicant<Worker>(new Worker()));
		Course.registerCourse1(new Applicant<Student>(new Student()));
		Course.registerCourse1(new Applicant<HighStudent>(new HighStudent()));
		Course.registerCourse1(new Applicant<MiddleStudent>(new MiddleStudent()));
		// Applicant<? extends Student> applicant = Student 및 해당자식클래스 참조 가능
		Course.registerCourse2(new Applicant<Student>(new Student()));
		Course.registerCourse2(new Applicant<HighStudent>(new HighStudent()));
		Course.registerCourse2(new Applicant<MiddleStudent>(new MiddleStudent()));
		// Applicant<? super Worker> applicant = Worker 및 해당 부모클래스 참조 가능
		Course.registerCourse3(new Applicant<Person>(new Person()));
		Course.registerCourse3(new Applicant<Worker>(new Worker()));

	}
}

class Person {

}

class Worker extends Person {

}

class Student extends Person {

}

class HighStudent extends Student {

}

class MiddleStudent extends Student {

}

class Applicant<T> {
	public T kind;

	public Applicant(T kind) {
		super();
		this.kind = kind;
	}

}

class Course {
	public static void registerCourse1(Applicant<?> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) Course1을 등록함.");
	}

	public static void registerCourse2(Applicant<? extends Student> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) Course2을 등록함.");
	}

	public static void registerCourse3(Applicant<? super Worker> applicant) {
		System.out.println(applicant.kind.getClass().getSimpleName() + "이(가) Course3을 등록함.");
	}
}
