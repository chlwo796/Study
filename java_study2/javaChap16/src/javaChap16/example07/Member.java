package javaChap16.example07;

public class Member {
	private String id;
	private String name;

	public Member(String id, String name) {
		super();
		this.id = id;
		this.name = name;
		System.out.println("Member(String id, String name)");
	}

	public Member(String id) {
		super();
		this.id = id;
		System.out.println("Member(String id)");
	}

	@Override
	public String toString() {
		String info = "{id: " + id + ", name: " + name + "}";
		return info;
	}
}
