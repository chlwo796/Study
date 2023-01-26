package javaMid1.ch07;

public class C extends B{
	private String school;

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	public void printAll() {
		System.out.println(getAge());
		System.out.println(getName());
		System.out.println(getPhone());
		System.out.println(getSchool());
	}
}
