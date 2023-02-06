package javaMid7.ex01;

public class OutterEx01 {
	public static void main(String[] args) {
//		OutterA는 인스턴스 멤버 클래스 객체화 하기
		OutterA o = new OutterA();
		OutterA.InnerA ia = o.new InnerA();

//		OutterB 정적멤버 클래스 객체화 하기
		OutterB.InnerB oi = new OutterB.InnerB();
		oi.ia = 100;
		oi.iam();
//		static 붙어있는 멤버들은 클래스명.멤버변수 클래스명.메소드명()
		OutterB.InnerB.sia = 200;
		OutterB.InnerB.siaM();
	}
}
