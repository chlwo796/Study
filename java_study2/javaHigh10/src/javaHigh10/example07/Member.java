package javaHigh10.example07;

import java.io.Serializable;

public class Member implements Serializable {
	private static final long serialVersionUID = 896244851836433053L;
	private String id;
	private String name;

	public Member(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return id + ": " + name;
	}
}
