package javaHigh11.example10;

public class Student {
	private String name;
	private String sex;
	private int score;
	private String grade;

	public Student(String name, String sex, int score, String grade) {
		super();
		this.name = name;
		this.sex = sex;
		this.score = score;
		this.grade = grade;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public int getScore() {
		return score;
	}

	public Student(String name, String sex, int score) {
		super();
		this.name = name;
		this.sex = sex;
		this.score = score;
	}
}