package javaChap17.example07;

public class Student1 implements Comparable<Student1> {
	private String name;
	private int score;

	public Student1(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	@Override
	public int compareTo(Student1 o) {
		// 점수기준으로 정렬
		return Integer.compare(score, o.score);
	}
}
