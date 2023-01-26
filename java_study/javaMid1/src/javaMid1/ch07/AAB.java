package javaMid1.ch07;

public class AAB extends AA{
	private int a3 = 90;

	public int getA3() {
		return a3;
	}

	public void setA3(int a3) {
		this.a3 = a3;
	}
	public void printAAB() {
		System.out.println(getA2());
		System.out.println(getA3());
	}
}