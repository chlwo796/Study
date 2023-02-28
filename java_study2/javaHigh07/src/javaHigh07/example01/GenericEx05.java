package javaHigh07.example01;

public class GenericEx05 {
	public static void main(String[] args) {
		Box1<String> box1 = new Box1<String>();
		box1.setT("È«±æµ¿");
		System.out.println(box1.getT());

		Box2<String, Integer> box2 = new Box2<String, Integer>();
		box2.setS("È«±æµ¿");
		box2.setT(30);
		System.out.println(box2.getS());
		System.out.println(box2.getT());
		Box2<Boolean, Box1<String>> box3 = new Box2<Boolean, Box1<String>>();
		box3.setS(true);
		box3.setT(new Box1<String>("½Å°Ë´ë»ó"));
		if (box3.getS()) {
			System.out.println(box3.getT().getT());
		}
	}

	public <A, B> void gM() {

	}
}

class Box1<T> {
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public T play() {
		return t;
	}

	public Box1() {
		// TODO Auto-generated constructor stub
	}

	public Box1(T t) {
		super();
		this.t = t;
	}

}

class Box2<S, T> {
	private S s;
	private T t;

	public S getS() {
		return s;
	}

	public void setS(S s) {
		this.s = s;
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public Box2(S s, T t) {
		super();
		this.s = s;
		this.t = t;
	}

	public Box2() {
		// TODO Auto-generated constructor stub
	}

}