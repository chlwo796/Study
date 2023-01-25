package b;

public class B {
//	(default)는 해당 패키지에서만 사용
//	A패키지에서 사용하려면 public 접근제한자를 사용해야 한다.
	
//	static int sb = 100;	
//	int ib = 200;
	
//	private static int sb = 100;	// private = b패키지에서만 사용 가능
//	private int ib = 200;
	
//	실무방식 private field, public method
	private static int sb = 100;
	private int ib = 200;
	
	public static int getSb() {
		return sb;
	}
	public static void setSb(int sb) {
		B.sb = sb;
	}
	public int getIb() {
		return ib;
	}
	public void setIb(int ib) {
		this.ib = ib;
	}
}