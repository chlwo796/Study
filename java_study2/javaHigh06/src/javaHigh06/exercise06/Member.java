package javaHigh06.exercise06;

public class Member {
	private String id;
	private String name;

	public Member(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + ": " + name;
	}
}