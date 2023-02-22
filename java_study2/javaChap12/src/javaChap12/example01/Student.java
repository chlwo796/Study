package javaChap12.example01;

public class Student {
	private int no;
	private String name;

	public Student(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return name.hashCode() + no;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Student) {
			Student target = (Student) obj;
			return no == target.no && name.equals(target.name);
		}
		return false;
	}
}