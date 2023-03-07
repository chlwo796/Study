package javaHigh10.example07;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = -1209488302855456305L;
	private String name;
	private int score;
	private boolean sex;

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}

	public Student(String name, int score, boolean sex) {
		super();
		this.name = name;
		this.score = score;
		this.sex = sex;
	}
}