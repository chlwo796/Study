package javaChap12.example01;

public class Member {
	private String id;

	public Member(String id) {
		super();
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {
			Member target = (Member) obj;
			return id.equals(target.id);
		}
		return false;
	}
}