package javaMid1.ch07;

public class A extends P {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void printM() {
		System.out.println(name);
		System.out.println(getPhone()); // 상속관계 확인, 부모클래스의 것을 바로 가져다 쓴다
		
	}

}
