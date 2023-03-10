package javaHigh11.example04;

public class Student {
	private String name;
	private int age;
	private double scope;

	public Student(String name, int age, double scope) {
		super();
		this.name = name;
		this.age = age;
		this.scope = scope;
	}

	public double getScope() {
		return scope;
	}

	public void setScope(double scope) {
		this.scope = scope;
	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
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
}