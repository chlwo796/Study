2023년 2월 5일 일요일

---

## chap.07 polymorphism

### 1. 타입변환과 다형성

1. 다형성 개념

   - 사전 : 같은 타입이지만, 실행결과가 다양한 객체를 이용할 수 있는 성질
   - 코드 : 하나의 타입에 여러 객체를 대입함으로서 다양한 기능을 이용할 수 있도록 해주는 것
   - 자바
     - 부모클래스로 타입변환을 허용하는 것.
     - 부모타입에 모든 자식 객체가 대입될 수 있는 것.
     - 한 타입의 참조변수로 여러 타입의 객체를 참조할 수 있도록 하는 것.
     - 부모클래스 타입의 참조변수로 자식 클래스의 인스턴스를 참조할 수 있도록 하는 것.

2. 다형성 이용분야

   - 객체를 부품화 할 수 있다.

3. 다형성의 구조

```java
public class A {

}
public class B extends A {

}
public class Main {
	public static void main(String[] args) {
		A a = new B();  // 다형성의 기본 구조, 부모타입의 참조변수에 자식객체의 주소를 참조한다.
	}
}
```

4. 다형성의 성질

   - **부모타입으로 자동 타입 변환된 이후에는 부모클래스에 선언된 필드와 메소드만 접근이 가능하다.**
   - **변수는 자식객체를 참조하지만, 변수로 접근 가능한 멤버는 부모클래스 멤버로만 한정된다.**
   - **자식이 부모 메소드를 오버라이딩한다면 자식클래스의 메소드가 대신 호출된다.**

```java
public class A {
	void methodA1() {
		System.out.println("A1 부모메소드");
	}

	void methodA2() {
		System.out.println("A2 부모메소드");
	}
}
public class B extends A {
	@Override
	void methodA2() {
		System.out.println("오버라이딩 A2 자식메소드");
	}

	void methodB1() {
		System.out.println("B1 자식메소드");
	}
}
public class Main {
	public static void main(String[] args) {
		A a = new B();  // 다형성시전

		a.methodA1();
		a.methodA2();
//		a.methodB1();	// 부모타입으로 자식만의 메소드에 접근할 수 없다.(오버라이딩, 혹은 새로운 자식객체필요)
	}
}
```

### 2. 필드의 다형성

1. 자동타입변환이 왜 필요한 이유(자식타입으로 사용하면 될 것을 부모타입으로 변환하여 사용하는 이유)

   - 동일한 타입을 사용하지만, 다양한 결과가 나오도록 구현하기 위해서이다.
   - 필드의 값을 다양화함으로서, 실행결과가 다르게 나오도록 구현하는데, 필드의 타입은 변함이 없지만 실행 도중에 어떤 객체를 필드로 저장하느냐에 따라 실행결과가 달라질 수 있다.

2. 이용분야

   - 객체 지향 프로그램에서 수많은 객체들이 서로 연결되고 각자의 역할을 하게 되는데, **이 객체들은 다른객체로 교체될 수 있어야 한다.**
     ![](https://cafeptthumb-phinf.pstatic.net/MjAyMDExMThfMTkw/MDAxNjA1NjkxMDA4Mjg1.o8G_WrYPd-bw0uRS933QVugAkScm0Hjvwfnz0eHtYLgg.UR_p2iBgzHlY70gSMVAZgqqENlUElSjke1P5dtWZ8c0g.PNG/a1.PNG?type=w1600)

### 3. 여러 종류의 객체를 배열로 다루기

- 부모타입의 참조변수로 자식 타입의 객체를 참조하는 것이 가능하므로, 부모타입의 참조변수 배열을 사용하면 공통의 조상을 가진 서로 다른 종류의 객체를 배열로 묶어서 다룰 수 있다.

```java
Product p1 = new Tv();
Product p2 = new Computer();
Product p3 = new Audio();

Product[] p = new Product[3];   // Product 타입의 배열 생성
p[0] = new Tv();
p[1] = new Computer();
p[2] = new Audio();
```

### 4. 매개변수의 다형성

- 매개값을 다양화 하기 위해 매개변수에 자식 타입 객체를 지정할 수 있다.
- 매개값의 자동 타입 변환과 메소드 오버라이딩을 이용해서 매개변수의 다형성을 구할 수 있다.

![](https://cafeptthumb-phinf.pstatic.net/MjAyMDExMThfMjY1/MDAxNjA1NjkwOTk0MzM0.2nQ-8PMhk88poTY7jiTJDQ_LSzHDOnKzmfqJ96E_H_wg.lJlqPezxdSpdKI9lti1ooFujYsZcxnUGKduDFqJT2Tkg.PNG/a2.PNG?type=w1600)

```java
public class A {
    void methodA() {
        System.out.println("부모클래스");
    }
}
public class B extends A {

    @Override
    void methodA() {
        System.out.println("자식클래스");
    }
}
public class C {
    void methodC(A a) {  // 자식클래스의 참조주소를 가진 매개변수 b 는 부모클래스타입의 a라는 매개변수로 받는다.
        a.methodA(); // B의 주소를 가진 매개변수 a로 methodA를 호출한다. 다형성의 연계
    }
}
public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        C c = new C();
        B b = new B();
        c.methodC(b);    // 자식클래스타입의 b라는 변수를 매개변수로 methodC를 호출한다.
    }
}
```

### 5. 강제 타입 변환(casting)

1. 강제 타입 변환은 부모타입을 자식 타입으로 변환하는 것을 말한다.

   - 모든 부모 타입을 자식클래스로 변환할 수 있는 것은 아니다.
   - 자식타입이 부모타입으로 자동 변환한 후 다시 자식타입으로 변환할 때 강제 타입 변환을 사용할 수 있다.

2. 구조

   ```java
           A a = new B();  // 부모클래스 A와 자식클래스B의 다형성, 자동 타입 변환
           B b = (B) a;    // 이후 downcasting, 강제 타입 변환
   ```

3. 이용분야

   - 자식타입이 부모타입으로 자동변환하면 부모타입에 선언된 필드와 메소드만 사요가능하다는 제약 사항이 따른다.
   - 자식타입에 선언된 필드와 메소드를 꼭 사용해야 한다면 강제 타입변환을 해서 자식타입으로 변환한 다음 자식타입의 필드와 메소드를 사용하면 된다.

### 6. instanceof 연산자

1. 이용분야

   - 어떤 객체가 어떤 클래스의 인스턴스인지 확인하기
   - 강제 형변환이 필요한 경우, 해당 객체가 클래스를 참조할 수 없을 때 강제로 형변환하면 예외가 발생할 수 있는데, 이를 방지하기 위해 조건문에 사용한다.
   - 참이면 true, 거짓이면 false를 리턴한다.

   ```java
   if(a instanceof B){
       // 강제형변환
   }else{
       // 형변환하지 않는다.
   }
   ```

2. 구조

   `boolean result = a(객체,부모) instanceof B(타입,자식);`
