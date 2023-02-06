package javaBasic5.day01.dao;

public class BookDao {
	private String name;
	private int age;
	private int score;

	public BookDao() {
		// TODO Auto-generated constructor stub
	}
	public BookDao(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
