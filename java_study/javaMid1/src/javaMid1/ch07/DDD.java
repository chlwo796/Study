package javaMid1.ch07;

public class DDD extends DD {
	int aaa;

	public int getAa() {
		return aaa;
	}

	public void setAa(int aaa) {
		this.aaa = aaa;
	}

	public DDD() {
//		super(); // 기본으로 생략되어있다.
		System.out.println("DDD의 기본생성자");
	}
}