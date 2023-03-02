package javaChap13.example05;

public class GenericExample {
	public static void main(String[] args) {
		
		Course.registerCourse1(new Applicant<Person>(new Person()));
		Course.registerCourse1(new Applicant<Student>(new Student()));
		Course.registerCourse1(new Applicant<Worker>(new Worker()));
		Course.registerCourse1(new Applicant<HighSchool>(new HighSchool()));
		Course.registerCourse1(new Applicant<MiddleStudent>(new MiddleStudent()));
		
		Course.registerCourse2(new Applicant<Student>(new Student()));
		Course.registerCourse2(new Applicant<HighSchool>(new HighSchool()));
		Course.registerCourse2(new Applicant<MiddleStudent>(new MiddleStudent()));
		
		Course.registerCourse3(new Applicant<Person>(new Person()));
		Course.registerCourse3(new Applicant<Worker>(new Worker()));
	}
}
