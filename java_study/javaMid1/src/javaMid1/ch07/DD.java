package javaMid1.ch07;

public class DD extends D {
	int aa;

	public int getAa() {
		return aa;
	}

	public void setAa(int aa) {
		this.aa = aa;
	}

	public DD() {
//		super(200);	// super = 부모생성자 호출, 부모의 명시적생성자 호출 후 부모의 기본생성자 패스
//		부모클래스의 input타입이 맞는 생성자를 호출
		System.out.println("이곳은 DD클래스의 기본생성자");
	}
	public DD(int aa) {
		System.out.println("DD 명시적 생성자");
	}
}
