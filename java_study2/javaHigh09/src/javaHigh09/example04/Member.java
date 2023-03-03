package javaHigh09.example04;

public class Member {
	private String id;
	private String name;
	public Member(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Member(String id) {
		super();
		this.id = id;
	}
	@Override
	public String toString() {
		String info = "{id: " + id+ ", name : " + name + " }";
		return info;
	}
}
