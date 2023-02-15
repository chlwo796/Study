package javaHigh04.example03;

public class School {
	private String teacher;
	private String grade;
	private int stNumber;
	private School school;

	public School(String grade, int stNumber) {
		super();
		this.grade = grade;
		this.stNumber = stNumber;
	}

	public School(String teacher, School school) {
		super();
		this.teacher = teacher;
		this.school = school;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getStNumber() {
		return stNumber;
	}

	public void setStNumber(int stNumber) {
		this.stNumber = stNumber;
	}

}
