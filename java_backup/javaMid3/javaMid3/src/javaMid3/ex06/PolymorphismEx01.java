package javaMid3.ex06;

public class PolymorphismEx01 {

	public static void main(String[] args) {
//		다형성 Animal animal = new Cat();, 매우 중요한 개념

		Animal animal = new Cat(); // Cat extends Animal
//		상속관계이므로 데이터를 공유한다.
//		작은타입 = 자식클래스, 큰타입 = 부모클래스

//		Cat cat = new Animal();	// 반대의 경우 타입미스매치 오류 발생

//		int a = 10;		// 큰 타입의 실수형자료에 보다 작은 정수형자료를 넣어도 오류x
//		double b = a;	// 데이터타입과 연관지어볼 수 있다.
	}
}