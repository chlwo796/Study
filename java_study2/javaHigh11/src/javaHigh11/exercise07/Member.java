package javaHigh11.exercise07;

public class Member {
	private String name;
	private String job;

	public String getName() {
		return name;
	}

	public String getJob() {
		return job;
	}

	public Member(String name, String job) {
		super();
		this.name = name;
		this.job = job;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{name:" + name + ", job:" + job + "}";
	}
}