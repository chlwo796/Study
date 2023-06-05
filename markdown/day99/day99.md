2023년 5월 26일 금요일

---

## day99

### java

```java
package exam2;

public class Car {
	// 객체지향 언어의 특징
	// 1. 캡슐화 : 객체의 속성과 행위(동작)을 하나로 묶고, 실제 구현 내용 일부를 외부에 감추어 은닉하는 기법
	//			 외부 객체는 객체의 내부 구조를 알지 못하게 하고, 내부 객체에서는 제어하여 제공하는 필드와
	// 			 메소드만 이용할 수 있다.
	// 2. 정보은닉 : 캡슐화 정보들을 밖에서 접근 불가능하도록 하는 것
	//			   변수(필드)와 메소드(함수)를 하나의 캡슐 안에 묶어 놓음
	// 3. 추상화 : 어떤 실체(객체, 사물)로부터 공통적인 부분이나 관심 있는 특성들만 하나로 모은 것
	//   		 어떤 하위 클래스들에 존재하는 공통적인 메소드를 인터페이스로 정의하는 것도 추상화
	// 4. 다형성 : 같은 모양의 함수가 상황에 따라 다르게 동작하는 것
	// 			  오버로딩 : 함수 이름이 같고, 매개변수 타입과 개수가 같아야 하고, 리턴값도 같아야 함
	// 5. 상속성 : 부모 클래스에서 새로운 기능을 추가해 자식 클래스를 만들어 사용하는 기법
	//   		 자식 클래스애서 따로 정의하지 않아도 부모 클래스에서 정의된 것들을 자동으로 상속받아 구현


	// #1. 자바
	// 1) 클래스 만들기(=구조, 틀, 붕어빵틀, 설계도)
	// 2) 객체 생성(붕어빵 만들기, 아파트 짓기..)
	// 3) 객체를 사용하기(붕어빵 먹기, 아파트에 살기..)
	// 객체를 사용하기 위해서 : 클래스 만들고, 객체 생성, 객체를 사용

	// 1. 노랑 자동차, 파랑 자동차, 검정색 자동차, -> 자동차틀
	// 클래스(틀) : 특성(속성), 동작
	// 자동차의 속성 - 모델, 색상, 속도 -> 필드
	// 자동차로 하고(보여주고) 싶은 동작 - 자동차의 정보를 제공, 자동차의 주행 -> 메소드
	// 클래스의 구조 : 필드, 생성자, 메소드

	// # 1. 필드 = 객체 안에 만들어짐, 메모리의 힙영역에 생성
	// 타입 필드명;
	// 타입 필드명 = value;
	// 접근제한자생략 = default
	// public String name; // 접근제한자 같이 선언
	// private String name;
	String name;
	String color;
	int speed = 300;

	// # 2. 생성자 = 객체를 사용할 수 있도록 준비시키기, 객체 초기화
	// 접근제한자 클래스명(){실행할 코드} // 기본생성자
	// 접근제어자 클래스명(매개변수..){실행할 코드}
	public Car() {
		// TODO Auto-generated constructor stub
	}
	public Car(String name, String color, int speed) {
		this.name = name; // this.필드명 = 지역변수명; this-자기 자신 객체, 자신의 객체가 있는 곳의 주소
		this.color = color;
		this.speed = speed;
	}

	// # 3. 메소드 = 동작방식, 수행할 기능들을 정의, 처리하는 방식
	// 접근제한자 리턴타입 메소드명(매개변수..){실행할코드들}
	public void showInfo() {
		System.out.println("자동차 이름 : " + name); // this.name
		System.out.println("자동차 색상 : " + color); // this.color
		System.out.println("자동차 속도 : " + speed); // this.speed
	}
	public void drive(int maxSpeed) {
		System.out.println(name + "의 기본 속력은 " + speed + "이지만");
		System.out.println("현재는 최대속력인 " + maxSpeed + "이지만");
	}
}
```

```java
package exam2;

public class CarExam {
	public static void main(String[] args) {
		// 클래스(설계도, 붕어빵틀) -> 객체 생성(붕어빵 만들기) -> 객체 사용하기

		// # 2. 객체 생성(붕어빵 만들기)
		// 어떤 붕어빵틀인지 붕어빵 담을 그릇 = 붕어빵 만들기
		// 클래스명 참조변수 = new 클래스명();

		Car car = new Car();
		Car carYellow = new Car("아우디", "노랑", 250);
		Car carBlue = new Car("소나타", "파랑", 280);

		car.name= "벤츠";
		car.color= "green";
		car.speed = 3000;
		car.showInfo();
		System.out.println();

		carYellow.showInfo();
		carYellow.drive(300);
		car.showInfo();
		System.out.println();

		carBlue.showInfo();
		carBlue.drive(290);
		car.showInfo();
		System.out.println();
	}
}
```
