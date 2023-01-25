package ch06.day02;

import java.util.Scanner;

public class NcsTest {

	public static void main(String[] args) {

		School school = new School();

		Scanner sc = new Scanner(System.in);

		System.out.println("이름>");
		school.setName(sc.nextLine());
		System.out.println("학교명>");
		school.setSchoolName(sc.nextLine());
		System.out.println("학년>");
		school.setGrade(sc.nextInt());

		System.out.println("Name : " + school.getName());
		System.out.println("School : " + school.getSchoolName());
		System.out.println("Grade : " + school.getGrade());

	}

}

class School {
	String name;
	String schoolName;
	int grade;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
}