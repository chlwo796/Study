package javaHigh11.example05;

public class Student implements Comparable<Student> {
	private String name;
	private int score;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return name.compareTo(o.name);
//		return Integer.compare(score, o.score);
	}
}