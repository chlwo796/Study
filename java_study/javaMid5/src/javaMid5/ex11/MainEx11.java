package javaMid5.ex11;

public class MainEx11 {
	public static void main(String[] args) {
		Activity activity = new MainActivity();
		activity.onCreate(); // 순서 = 자식메소드 -> 부모메소드 -> 자식메소드
	}
}
