package javaBasic5.day01;

import javaBasic5.day01.dao.BookDao;

public class ClassEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex01.a(); // static method 호출
		Ex01 ex01 = new Ex01(); // instance method를 호출하는 방법
		ex01.b(); // 참조변수명.메소드명();

//		패키지만들기 = 폴더만들기
//		다른패키지 안에 있는 클래스 사용한다. is a, 강아지는 동물이다. ->상속관계 extends, implements
//		has a ~를 가지고 있다. 자동차는 핸들을 가지고 있다.(부품) -> 집합관계 import

		BookDao bookdao = new BookDao(); // 하위패키지, 집합관계 import
//		bookdao.name = "홍길동";	// private로 데이터를 감춤(정보은닉), 캡슐화
		bookdao.setName("홍길동"); // public으로 선언한 메소드에 값을 넣어준다

//		접근제한자 = public, protected, default(package), private
//		싱글톤 = 날짜데이터를 import할 때, 다른 class에서 매번 객체화 하여 참조변수를 만들 필요가 없다.
	}
}

class Ex01 {

	static int k = 100;
	int s = 200;

	static void a() {
		k = k + 200;
//		s = s+k; // instance변수는 인스턴스화 해야 사용가능
	}

	void b() {
		k = k + 100; // instance method에서 static 변수도 사용 가능
		s = s + 100;
	}
}