package singleton;

public class Single {

	private static Single s = new Single();

	private Single() { // private = 다른 클래스에서는 사용 불가

	}
	private String now() {
		return "2023-01-25";
	}
	
	public static Single getInstance() {
		return s;	// public method로 인스턴스화 한 객체의 주소 리턴.
	}
}