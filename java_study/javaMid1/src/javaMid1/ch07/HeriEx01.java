package javaMid1.ch07;

public class HeriEx01 {

	public static void main(String[] args) {
//		상속 개념, D,DD,DDD 참고, 객체생성 후 생성자순서
//		method overloading 후 흐름 파악
		
//		D클래스 객체생성 -> heap memory D 생성
//		D d = new D();
		
//		DD dd = new DD();	// D,DD가 같이 올라가지만, 부모클래스 D를 먼저 memory에 올린다
		
		DDD ddd = new DDD(); // D,DD,DDD가 같이 올라가지만, 부모클래스 D를 먼저 memory에 올린 후, DD, DDD 순서
	}
}